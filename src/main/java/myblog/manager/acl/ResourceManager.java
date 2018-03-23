package myblog.manager.acl;

import java.util.List;

import org.springframework.data.domain.Page;

import myblog.dao.entity.AppResource;
import myblog.dao.repo.Spe.AppResourcePageSpe;
import myblog.model.acl.ResourceTreeModel;

public interface ResourceManager {

	/**
	 * 获取根菜单资源
	 */
	List<AppResource> findRootMenu();
	
	/**
	 * 获取资源菜单对应子菜单资源
	 */
	List<AppResource> listByParent(String menuId);
	
	/**
	 * 获取jstree
	 */
	List<ResourceTreeModel> getResourceTree(String id);
	
	/**
	 * 分页查询
	 */
	Page<AppResource> pageQuery(AppResourcePageSpe pageSpe);
	
	AppResource findById(String id);
	
}
