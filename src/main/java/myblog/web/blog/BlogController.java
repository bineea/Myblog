package myblog.web.blog;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.entity.Content;
import myblog.dao.entity.dict.ContentStatus;
import myblog.dao.repo.Spe.BlogContentPageSpe;
import myblog.manager.article.ArticleManager;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "blog")
public class BlogController extends AbstractController {
	
	private final String prefix = "blog/";
	
	@Autowired
	private ArticleManager articleManager;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String blogHomeGet(@ModelAttribute("spe") BlogContentPageSpe spe) {
		return prefix + "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String blogHomtPost(@ModelAttribute("spe") BlogContentPageSpe spe, Model model) {
		spe.setContentStatuses(Arrays.asList(ContentStatus.NORMAL,ContentStatus.FORBIDCOMMENT));
		Page<Content> page = articleManager.blogPageQuery(spe);
		model.addAttribute("queryResult", page.getContent());
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		return prefix + "result";
	}
}
