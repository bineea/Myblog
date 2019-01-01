package myblog.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class BlogCategoryController extends AbstractController {

	private final String prefix = "blog/common/";
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String categoryPost(Model model) {
		
		return prefix + "categoryResult";
	}
}
