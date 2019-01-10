package myblog.manager.comment;

import java.util.List;

import myblog.model.comment.CommentModel;

public interface CommentManager {

	void test();
	
	List<CommentModel> allCommentsByContent(String contentId);
}
