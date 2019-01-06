package myblog.web.blog;

import java.util.List;

import myblog.dao.entity.Comment;

public class test {

	public List<CommentModel> commentList; 
}

class CommentModel {
	private List<CommentModel> commentList;
	private Comment comment;
	private Comment parentComment;
	
}
