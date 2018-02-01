package myblog.manager.acl;

import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.Role;

public interface AclManager {

	AppResource findByUrlMethod(String url, RequestMethod method);
	
	String checkAuth(Role role, AppResource resource); 
}
