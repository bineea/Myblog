package myblog.web.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.entity.Category;
import myblog.dao.repo.Spe.BlogContentCatePageSpe;
import myblog.dao.repo.Spe.BlogContentPageSpe;
import myblog.manager.article.CategoryManager;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class HomeController extends AbstractController {
	
	private final String prefix = "blog/";
	
	@Autowired
	private CategoryManager categoryManager;
	
	@RequestMapping(value = "/homeIndex", method = RequestMethod.GET)
	public String blogHomeIndexGet(@ModelAttribute("spe") BlogContentPageSpe spe) {
		return prefix + "homeIndex";
	}
	
	@RequestMapping(value = "/homeCategory/{categoryId}", method = RequestMethod.GET)
	public String blogHomeCategoryGet(@ModelAttribute("spe") BlogContentCatePageSpe spe, 
			@PathVariable(value = "categoryId", required = true) String categoryId,
			Model model) {
		Category category = categoryManager.findById(categoryId);
		model.addAttribute("category", category);
		return prefix + "homeCategory";
	}
}
