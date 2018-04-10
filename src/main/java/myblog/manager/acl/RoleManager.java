package myblog.manager.acl;

import java.util.List;

import org.springframework.data.domain.Page;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.Role;
import myblog.dao.repo.Spe.RolePageSpe;
import myblog.model.acl.ResourceTreeModel;

public interface RoleManager {

	/**
	 * 分页查询
	 * @param spe
	 * @return
	 */
	Page<Role> pageQuery(RolePageSpe spe);
	
	/**
	 * 获取所有资源，并选中该角色拥有资源
	 * @param roleId
	 * @return
	 */
	List<ResourceTreeModel> getAllResource(String roleId);
	
	/**
	 * 配置角色资源
	 * @param roleId
	 * @param resourceIds
	 */
	void configRole(String roleId, String[] resourceIds) throws MyManagerException;
}
