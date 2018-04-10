package myblog.manager.acl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.AppResource;
import myblog.dao.entity.AppResource.MenuType;
import myblog.dao.entity.Role;
import myblog.dao.entity.RoleResource;
import myblog.dao.repo.Spe.RolePageSpe;
import myblog.dao.repo.jpa.AppResourceRepo;
import myblog.dao.repo.jpa.RoleRepo;
import myblog.dao.repo.jpa.RoleResourceRepo;
import myblog.manager.AbstractManager;
import myblog.model.acl.ResourceTreeModel;
import myblog.model.acl.TreeStateModel;

@Service
public class RoleManagerImpl extends AbstractManager implements RoleManager {

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private AppResourceRepo resourceRepo;
	@Autowired
	private RoleResourceRepo roleResourceRepo;
	@Autowired
	private RoleResourceMapHolder roleResourceHolder;

	@Override
	public Page<Role> pageQuery(RolePageSpe spe) {
		return roleRepo.findAll(spe.handleSpecification(), spe.getPageRequest());
	}

	@Override
	public List<ResourceTreeModel> getAllResource(String roleId) {
		List<ResourceTreeModel> allMenu = resourceRepo.findByMenuType(MenuType.COLUMN).stream()
				.filter(resource -> !StringUtils.hasText(resource.getMenuId())).sorted((res1, res2) -> {
					return res1.getList().compareTo(res2.getList());
				}).map(resource -> {
					ResourceTreeModel rootModel = ResourceTreeModel.initModel(resource);
					return getResourceTreeModel(resource, roleId, rootModel);
				}).collect(Collectors.toList());
		return allMenu;
	}
	
	private ResourceTreeModel getResourceTreeModel(AppResource resource, String roleId, ResourceTreeModel parentModel) {
		List<AppResource> resourceList = resourceRepo.findByMenuId(resource.getId());
		if (resourceList == null || resourceList.isEmpty()) {
			parentModel.setChildren(false);
			RoleResource roleResource = roleResourceRepo.findByRoleResourceId(resource.getId(), roleId);
			if(roleResource != null)
				parentModel.setState(new TreeStateModel().setSelected(true));
		}
		else {
			List<ResourceTreeModel> modelList = new ArrayList<>();
			resourceList.stream().forEach(res -> {
				ResourceTreeModel model = ResourceTreeModel.initModel(res);
				if(res.getMenuType() != MenuType.COLUMN)
					model.setType("link");
				modelList.add(getResourceTreeModel(res, roleId, model));
			});
			parentModel.setChildren(modelList);
		}
		return parentModel;
	}

	@Override
	@Transactional
	public void configRole(String roleId, String[] resourceIds) throws MyManagerException {
		Assert.hasText(roleId, "roleId不能为空");
		Assert.notEmpty(resourceIds, "resourceIds不能为空");
		Role role = roleRepo.findById(roleId).orElse(null);
		if(role == null)
			throw new MyManagerException("角色不存在，可能已经被其他用户删除");
		if(role.isSystem())
			throw new MyManagerException("不能配置系统内置角色的权限");
		roleResourceRepo.deleteByRoleId(roleId);
		for(String resourceId : resourceIds) {
			AppResource resource = resourceRepo.findById(resourceId).orElse(null);
			if(resource == null) continue;
			if(roleResourceRepo.findByRoleResourceId(resourceId, roleId) != null) continue;
			RoleResource roleResource = new RoleResource(role, resource);
			roleResourceRepo.save(roleResource);
		}
		// 清空角色拥有权限的缓存
		roleResourceHolder.removeRoleMenus(roleId);
	}

}
