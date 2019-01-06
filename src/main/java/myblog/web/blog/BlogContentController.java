package myblog.web.blog;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.common.tools.HttpResponseHelper;
import myblog.dao.entity.Content;
import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.entity.dict.ContentStatus;
import myblog.dao.repo.Spe.BlogContentCatePageSpe;
import myblog.dao.repo.Spe.BlogContentPageSpe;
import myblog.manager.article.ContentCateManager;
import myblog.manager.article.ContentManager;
import myblog.web.AbstractController;

@Controller
@RequestMapping("blog")
public class BlogContentController extends AbstractController {
	
	private final String prefix = "blog/";
	
	@Autowired
	private ContentManager contentManager;
	@Autowired
	private ContentCateManager contentCateManager;
	
	@RequestMapping(value = "/content/showCover/{id}")
	public void showCover(@PathVariable("id") String id, HttpServletResponse response) throws IOException, SQLException {
		Content content = contentManager.findById(id);
		if(content != null && content.getCover() != null)
			HttpResponseHelper.showPicture(content.getCover().getBinaryStream(), response);
	}
	
	@RequestMapping(value = "/contentIndex", method = RequestMethod.POST)
	public String contentIndexPost(@ModelAttribute("spe") BlogContentPageSpe spe, Model model) {
		spe.setContentStatuses(Arrays.asList(ContentStatus.NORMAL,ContentStatus.FORBIDCOMMENT));
		Page<Content> page = contentManager.blogPageQuery(spe);
		model.addAttribute("queryResult", page.getContent());
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		return prefix + "contentIndexResult";
	}
	
	@RequestMapping(value = "/contentCategory", method = RequestMethod.POST)
	public String contentCategoryPost(@ModelAttribute("spe") BlogContentCatePageSpe spe, Model model) {
		spe.setContentStatuses(Arrays.asList(ContentStatus.NORMAL,ContentStatus.FORBIDCOMMENT));
		Page<ContentCategoryMapping> page = contentCateManager.blogPageQuery(spe);
		model.addAttribute("queryResult", page.getContent());
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		return prefix + "contentCategoryResult";
	}
	
	@RequestMapping(value = "/recent", method = RequestMethod.POST)
	public String contentRecentPost(Model model) {
		List<Content> queryResult = contentManager.findRecentContent();
		model.addAttribute("queryResult", queryResult);
		return prefix + "common/recentResult";
	}
	
	@RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
	public String contentDetailPost(@PathVariable("id") String id, Model model) {
		Content content = contentManager.findById(id);
		model.addAttribute("content", content);
		return prefix + "contentDetail";
	}
}
