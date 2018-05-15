package myblog.web.article;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.dict.ContentStatus;
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
	public String articlePublishPost(@ModelAttribute("articleModel") ArticleModel articleModel, 
			HttpServletResponse response, Model model) 
			throws MyManagerException, IOException {
		String contentId = articleManager.createArticle(articleModel, ContentStatus.NORMAL);
		addSuccess(response, "成功发布文章");
		return prefix + "result";
	}
	
	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public String articleDraftPost(@ModelAttribute("articleModel") ArticleModel articleModel) 
			throws MyManagerException, IOException {
		String contentId = articleManager.createArticle(articleModel, ContentStatus.TEMPORARY);
		return prefix + "result";
	}
}
