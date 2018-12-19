package myblog.web.blog;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import myblog.common.tools.HttpResponseHelper;
import myblog.dao.entity.Content;
import myblog.manager.article.ContentManager;
import myblog.web.AbstractController;

@Controller
@RequestMapping("blog")
public class ContentController extends AbstractController {
	
	@Autowired
	private ContentManager contentManager;
	
	@RequestMapping(value = "/showCover/{id}")
	public void showCover(@PathVariable("id") String id, HttpServletResponse response) throws IOException, SQLException {
		Content content = contentManager.findById(id);
		if(content != null && content.getCover() != null)
			HttpResponseHelper.showPicture(content.getCover().getBinaryStream(), response);
	}
}
