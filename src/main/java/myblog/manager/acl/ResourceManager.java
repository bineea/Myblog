package myblog.manager.acl;

import java.util.List;

import org.springframework.data.domain.Page;

import myblog.dao.entity.AppResource;
import myblog.dao.repo.Spe.AppResourcePageSpe;
import myblog.model.acl.ResourceTreeModel;

public interface ResourceManager {

	List<AppResource> findRootMenu();
	
	List<AppResource> listByParent(String menuId);
	
	List<ResourceTreeModel> getResourceTree(String id);
	
	Page<AppResource> pageQuery(AppResourcePageSpe pageSpe);
}
