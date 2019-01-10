package myblog.model.comment;

import java.util.ArrayList;
import java.util.List;

import myblog.dao.entity.Comment;
import myblog.model.BaseModel;

public class CommentModel extends BaseModel {

	private boolean hasParentComment = false; // 是否存在父级评论
	private boolean hasReplies = false; // 是否存在回复
	private Comment comment; // 评论
	private Comment parentComment; // 父级评论
	private List<CommentModel> replyComment = new ArrayList<CommentModel>(); // 回复

	public boolean isHasParentComment() {
		return hasParentComment;
	}

	public void setHasParentComment(boolean hasParentComment) {
		this.hasParentComment = hasParentComment;
	}

	public boolean isHasReplies() {
		return hasReplies;
	}

	public void setHasReplies(boolean hasReplies) {
		this.hasReplies = hasReplies;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public List<CommentModel> getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(List<CommentModel> replyComment) {
		this.replyComment = replyComment;
	}

}
