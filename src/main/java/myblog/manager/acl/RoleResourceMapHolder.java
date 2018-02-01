package myblog.manager.acl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.RoleResource;
import myblog.dao.repo.jpa.RoleResourceRepo;

@Component
public class RoleResourceMapHolder {
	
	public static Map<String, Map<String, AppResource>> roleResourceMap = new ConcurrentHashMap<>();
	
	@Autowired
	private RoleResourceRepo roleResourceRepo;
	
	public Map<String, AppResource> handleMenu(String roleId) {
		
		Map<String, AppResource> resourceMap = roleResourceMap.get(roleId);
		if(resourceMap.isEmpty()){
			List<RoleResource> roleResourceList = roleResourceRepo.findByRoleId(roleId);
			roleResourceList.stream().map(roleResource -> roleResource.getResource()).forEach(resource -> {
				resourceMap.put(resource.getId(), resource);
			});
			roleResourceMap.put(roleId, resourceMap);
		}
		return resourceMap;
	}
	
	public boolean hasResource(String roleId, String resourceId) {
		
		Map<String, AppResource> resourceMap = handleMenu(roleId);
		return resourceMap.get(resourceId) != null;
	}
	
	/**
	 * 配置完角色权限后调用本方法清空角色拥有权限的缓存
	 * @param roleId
	 */
	public void removeRoleMenus(String roleId)
	{
		roleResourceMap.remove(roleId);
	}
}
