package myblog.manager.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import myblog.dao.entity.Role;
import myblog.dao.repo.jpa.RoleRepo;

@Service
public class MyFirstWebserviceImpl extends SpringBeanAutowiringSupport implements MyFirstWebservice {

	@Autowired
	private RoleRepo roleRepo;
	
	@WebMethod
	@Override
	public String sayHello(){
		System.out.println("----->>>>进入sayHello方法------");
		return "Hello World!!!";
	}

	@WebMethod
	@Override
	public List<Role> findRoleByName(String name) {
		Assert.hasText(name, "name不能为空");
		System.out.println("---------------->>>name:"+name);
		List<Role> list = roleRepo.findAll();
		System.out.println("---------------->>>list:"+list.toString());
		if(list == null || list.isEmpty())
			return new ArrayList<Role>();
		return list;
	}

}
