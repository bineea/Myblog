package myblog.web.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.entity.Content;
import myblog.dao.entity.dict.ContentStatus;
import myblog.dao.repo.Spe.ContentPageSpe;
import myblog.manager.article.ArticleManager;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "article/operate")
public class ArticleOperateController extends AbstractController {

	@Autowired
	private ArticleManager articleManager;
	
	private final String prefix = "article/operate/";
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet(@ModelAttribute("queryModel") ContentPageSpe spe, Model model) {
		
		model.addAttribute("status", ContentStatus.values());
		return prefix + "manage";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public String managePost(@ModelAttribute("queryModel") ContentPageSpe spe, Model model) {
		
		Page<Content> page= articleManager.pageQuery(spe);
		model.addAttribute("queryResult", page.getContent());
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		return prefix + "queryResult";
	}
}
