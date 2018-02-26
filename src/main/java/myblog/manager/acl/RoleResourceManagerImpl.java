package myblog.manager.acl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.AppResource.MenuType;
import myblog.dao.entity.RoleResource;
import myblog.dao.repo.jpa.RoleResourceRepo;
import myblog.model.acl.MenuModel;

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
	
	private MenuModel getRoleMenu(AppResource column, String roleId) {
		MenuModel menuModel = new MenuModel();
		List<AppResource> resources = roleResourceRepo.findByMenuIdRoleId(column.getId(), roleId).stream()
				.map(roleResource -> roleResource.getResource())
				.collect(Collectors.toList());
		resources.forEach(resource -> {
					if(resource.getMenuType() == MenuType.COLUMN)
					{
						menuModel.getColumnMenu().add(getRoleMenu(resource, roleId));
					}
					else if(resource.getMenuType() == MenuType.MENU)
					{
						menuModel.getResource().add(resource);
					}
				});
		if(resources.stream().anyMatch(resource -> resource.getMenuType() == MenuType.COLUMN))
			menuModel.setColumn(true);
		return menuModel;
	}

}
