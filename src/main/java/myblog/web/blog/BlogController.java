package myblog.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class BlogController extends AbstractController {
	
	private final String prefix = "blog/";
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String blogHomeGet() {
		
		return prefix + "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String blogHomtPost() {
		
		return prefix + "";
	}
}
