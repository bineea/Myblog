package myblog.manager.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MyFirstWebservice {

	@WebMethod
	public String sayHello();
}
