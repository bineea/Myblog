package myblog.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.repo.Spe.BlogContentPageSpe;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class HomeController extends AbstractController {
	
	private final String prefix = "blog/";
	
	@RequestMapping(value = "/homeIndex", method = RequestMethod.GET)
	public String blogHomeIndexGet(@ModelAttribute("spe") BlogContentPageSpe spe) {
		return prefix + "homeIndex";
	}
	
	@RequestMapping(value = "/homeCategory", method = RequestMethod.GET)
	public String blogHomeCategoryGet(@ModelAttribute("spe") BlogContentPageSpe spe) {
		return prefix + "homeCategory";
	}
}
