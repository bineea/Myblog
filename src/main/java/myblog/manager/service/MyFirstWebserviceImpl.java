package myblog.manager.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import myblog.manager.AbstractManager;

@WebService
@Service
public class MyFirstWebserviceImpl extends AbstractManager implements MyFirstWebservice {

	@WebMethod
	@Override
	public String sayHello(){
		logger.info("----->>>>进入sayHello方法------");
		return "Hello World!!!";
	}
}
