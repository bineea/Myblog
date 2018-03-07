package myblog.manager.acl;

import java.util.List;

import myblog.dao.entity.AppResource;

public interface ResourceManager {

	List<AppResource> findRootMenu();
	
	List<AppResource> listByParent(String menuId);
}
