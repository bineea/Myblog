package myblog.manager.acl;

import java.util.List;

import myblog.model.acl.MenuModel;

public interface RoleResourceManager {

	List<MenuModel> getRoleMenuList(String roleId);
}
