package myblog.web.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.manager.article.ContentCateManager;
import myblog.model.article.CategoryModel;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class BlogCategoryController extends AbstractController {

	private final String prefix = "blog/common/";
	@Autowired
	private ContentCateManager contentCateManager;
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String categoryPost(Model model) {
		List<CategoryModel> queryResult = contentCateManager.categoryStatistic();
		model.addAttribute("queryResult", queryResult);
		return prefix + "categoryResult";
	}
}
