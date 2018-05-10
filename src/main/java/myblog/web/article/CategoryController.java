package myblog.web.article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.web.AbstractController;

@Controller
public class CategoryController extends AbstractController {

	private final String prefix = "article/category/";
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String manageGet() {
		
		return prefix + "manage";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String managePost() {
		
		return prefix + "result";
	}
}
