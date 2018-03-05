package myblog.web.comment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.manager.comment.CommentManager;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentManager manager;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test()
	{
		manager.test();
	}
	
	@RequestMapping(value = "/testRequestHeader")
	public String requestHeader(@RequestHeader(value = "Accept-Language") String header, @RequestHeader(name = "Accept-Language") String name, 
			HttpServletRequest request) {
		System.out.println("header: " + header);
		System.out.println("name: " + name);
		return "index";
	}
}
