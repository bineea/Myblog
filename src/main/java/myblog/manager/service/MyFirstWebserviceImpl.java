package myblog.manager.service;

import javax.jws.WebService;

@WebService
public class MyFirstWebserviceImpl implements MyFirstWebservice {

	@Override
	public String sayHello(){
		
		return "Hello World!!!";
	}
}
