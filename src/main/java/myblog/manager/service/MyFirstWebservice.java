package myblog.manager.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import myblog.dao.entity.Role;

@WebService
public interface MyFirstWebservice {

	@WebMethod
	public String sayHello();
	
	@WebMethod
	public List<Role> findRoleByName(String name);
}
