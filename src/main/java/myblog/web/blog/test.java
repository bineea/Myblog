package myblog.web.blog;

import java.util.List;

import myblog.dao.entity.Comment;

public class test {

	public List<CommentModel> commentList; 
}
//初步设想:
//后台递归封装数据；前台递归展示数据
//前台ajax请求，后台将数据赋值到response中
class CommentModel {
	private List<CommentModel> commentList;
	private Comment comment;
	private Comment parentComment;
	
}
