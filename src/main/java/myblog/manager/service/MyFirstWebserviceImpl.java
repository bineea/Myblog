package myblog.manager.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService
@Service
public class MyFirstWebserviceImpl implements MyFirstWebservice {

	@WebMethod
	@Override
	public String sayHello(){
		
		return "Hello World!!!";
	}
}
