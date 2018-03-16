package myblog.manager.acl;

import java.util.List;

import myblog.dao.entity.AppResource;
import myblog.model.acl.ResourceTreeModel;

public interface ResourceManager {

	List<AppResource> findRootMenu();
	
	List<AppResource> listByParent(String menuId);
	
	List<ResourceTreeModel> getResourceTree(String id);
}
