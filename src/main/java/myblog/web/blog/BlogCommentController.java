package myblog.web.blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myblog.common.tools.HttpResponseHelper;
import myblog.common.tools.JsonTools;
import myblog.manager.comment.CommentManager;
import myblog.model.comment.CommentModel;
import myblog.web.AbstractController;

@Controller
@RequestMapping("blog")
public class BlogCommentController extends AbstractController {

	@Autowired
	private CommentManager commentManager;
	
	@RequestMapping(value = "/comment/all", method = RequestMethod.POST)
	public void allCommentsPost(@RequestParam("contentId") String contentId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CommentModel> modelList = commentManager.allCommentsByContent(contentId);
		HttpResponseHelper.responseJson(JsonTools.writeValueAsString(modelList), request, response);
	}
	
	@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
	public void addCommentsPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		addSuccess(response, "评论成功");
	}
}
