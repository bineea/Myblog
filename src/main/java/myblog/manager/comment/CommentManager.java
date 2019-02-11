package myblog.manager.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.Comment;
import myblog.model.comment.CommentModel;

public interface CommentManager {

	void test();
	
	/**
	 * 统计文章的所有评论
	 * @param contentId
	 * @return
	 */
	List<CommentModel> allCommentsByContent(String contentId);
	
	/**
	 * 添加评论
	 * @param comment
	 */
	void addComment(Comment comment, HttpServletRequest request) throws MyManagerException;
}
