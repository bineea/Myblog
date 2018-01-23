package myblog.dao.repo.Specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import myblog.common.pub.CommonAbstract;
import myblog.dao.entity.Comment;
import myblog.dao.entity.Content;
import myblog.dao.entity.User;
import myblog.dao.entity.dict.CommentStatus;
import myblog.dao.entity.dict.CommentType;
import myblog.dao.entity.dict.ContentModule;

public class CommentSpecification extends CommonAbstract {

	private Comment parentComment;// 回复的评论ID
	private Content content;// 评论的内容ID
	private ContentModule contentModule;// 评论的内容模型
	private int commentCount;// 评论的回复数量
	private User user;// 评论的用户ID
	private String author;// 评论的作者
	private CommentType commentType;// 评论的类型，默认是comment
	private String text;// 评论的内容
	private String agent;// 提交评论的浏览器信息
	private LocalDateTime createTime;// 评论的时间
	private String email;// 评论用户的email
	private CommentStatus status;// 评论的状态
	
	public Specification<Comment> pageAll() {
		Specification<Comment> spe = (arg0, arg1, arg2) -> null;
		return spe;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public ContentModule getContentModule() {
		return contentModule;
	}

	public void setContentModule(ContentModule contentModule) {
		this.contentModule = contentModule;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CommentStatus getStatus() {
		return status;
	}

	public void setStatus(CommentStatus status) {
		this.status = status;
	}

}
