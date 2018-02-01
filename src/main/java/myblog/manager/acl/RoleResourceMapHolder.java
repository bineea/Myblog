package myblog.manager.acl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import myblog.dao.entity.AppResource;
import myblog.dao.repo.jpa.RoleResourceRepo;

public class RoleResourceMapHolder {
	
	public static Map<String, Map<String, AppResource>> roleResources = new ConcurrentHashMap<>();
	
	@Autowired
	private RoleResourceRepo roleResourceRepo;
	
	public void handleMenu(String roleId) {
		
	}
}
