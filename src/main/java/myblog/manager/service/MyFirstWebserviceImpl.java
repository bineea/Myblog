package myblog.manager.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import myblog.dao.entity.Role;
import myblog.dao.repo.jpa.RoleRepo;
import myblog.manager.AbstractManager;

@Service
public class MyFirstWebserviceImpl extends AbstractManager implements MyFirstWebservice {

	@Autowired
	private RoleRepo roleRepo;
	
	@WebMethod
	@Override
	public String sayHello(){
		logger.info("----->>>>进入sayHello方法------");
		return "Hello World!!!";
	}

	@WebMethod
	@Override
	public List<Role> findRoleByName(String name) {
		Assert.hasText(name, "name不能为空");
		List<Role> list = roleRepo.findAll();
		if(list == null || list.isEmpty())
			return new ArrayList<Role>();
		return list;
	}

}
