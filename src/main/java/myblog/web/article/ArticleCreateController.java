package myblog.web.article;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.manager.article.ArticleManager;
import myblog.manager.article.CategoryManager;
import myblog.model.article.ArticleModel;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "article/create")
public class ArticleCreateController extends AbstractController {
	
	@Autowired
	private CategoryManager categoryManager;
	@Autowired
	private ArticleManager articleManager;
	
	private static final String prefix = "article/create/";

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String articleCreateGet(HttpServletRequest request, Model model) {
		model.addAttribute("categorys", categoryManager.findAll());
		return prefix + "manage";
	}
	
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public String articlePublishPost(@ModelAttribute("articleModel") ArticleModel articleModel) {
		
		return prefix + "";
	}
	
	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public void articleDraftPost(@ModelAttribute("articleModel") ArticleModel articleModel) {
		
	}
}
