package myblog.manager.acl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.AppResource.MenuType;
import myblog.dao.entity.RoleResource;
import myblog.dao.repo.jpa.RoleResourceRepo;
import myblog.model.acl.MenuModel;

@Service
public class RoleResourceManagerImpl implements RoleResourceManager {

	@Autowired
	private RoleResourceRepo roleResourceRepo;
	
	@Override
	public List<MenuModel> getRoleMenuList(String roleId) {
		
		List<MenuModel> menuList = new ArrayList<>();
		List<RoleResource> roleResourceList = roleResourceRepo.findByRoleId(roleId);
		List<AppResource> columnList = roleResourceList.stream().filter(roleResource -> roleResource.getResource().getMenuType() == MenuType.COLUMN)
				.filter(roleResource -> !StringUtils.hasText(roleResource.getResource().getMenuId()))
				.map(roleResource -> roleResource.getResource()).collect(Collectors.toList());
		columnList.stream().forEach(column -> {
			menuList.add(getRoleMenu(column, roleId));
		});
		return menuList;
	}
	
	private MenuModel getRoleMenu(AppResource resource, String roleId) {
		MenuModel menuModel = new MenuModel();
		menuModel.setResource(resource);
		if(resource.getMenuType() == MenuType.COLUMN)
		{
			menuModel.setColumn(true);
			roleResourceRepo.findByMenuIdRoleId(resource.getId(), roleId).stream()
											.map(roleResource -> roleResource.getResource())
											.forEach(res -> menuModel.getColumnMenu().add(getRoleMenu(res,roleId)));
		}
		return menuModel;
	}

}
