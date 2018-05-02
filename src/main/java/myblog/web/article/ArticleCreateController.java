package myblog.web.article;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "article/create")
public class ArticleCreateController extends AbstractController {
	
	private static final String prefix = "article/create/";

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet(HttpServletRequest request, Model model) {
		
		return prefix + "manage";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public void managePost() {
		
	}
}
