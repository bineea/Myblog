package myblog.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import myblog.common.entity.StringUUIDEntity;
import myblog.dao.entity.dict.CommentStatus;
import myblog.dao.entity.dict.CommentType;
import myblog.dao.entity.dict.ContentModule;

@Entity
@Table(name = "blog_comment")
public class Comment extends StringUUIDEntity {

	private Comment parentComment;// 回复的评论ID
	private Content content;// 评论的内容ID
	private ContentModule contentModule;// 评论的内容模型
	private int commentCount;// 评论的回复数量
	private int orderNum;// 排序编号，常用于置顶等
	private CommentType commentType;// 评论的类型，默认是comment
	private CommentStatus status;// 评论的状态
	private String author;// 评论的作者
	private String email;// 评论用户的email
	private String text;// 评论的内容
	private String ip;// 评论的IP地址
	private String agent;// 提交评论的浏览器信息
	private LocalDateTime createTime;// 评论的时间
	private String slug;// 评论的slug(伪静态)
	private int voteUp;// “顶”的数量
	private int voteDown;// “踩”的数量
	private String flag;// 标识
	private Double lat;// 纬度
	private Double lng;// 经度

	// 非持久化
	private String parentCommentId;// 回复的评论ID
	private String contentId;// 评论的内容ID

	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = true)
	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	@ManyToOne
	@JoinColumn(name = "content_id", nullable = true)
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "content_module")
	public ContentModule getContentModule() {
		return contentModule;
	}

	public void setContentModule(ContentModule contentModule) {
		this.contentModule = contentModule;
	}

	@Column(name = "comment_count")
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Column(name = "order_number")
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "comment_type")
	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "agent")
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Column(name = "create_time")
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Column(name = "slug")
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "comment_status")
	public CommentStatus getStatus() {
		return status;
	}

	public void setStatus(CommentStatus status) {
		this.status = status;
	}

	@Column(name = "vote_up")
	public int getVoteUp() {
		return voteUp;
	}

	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}

	@Column(name = "vote_down")
	public int getVoteDown() {
		return voteDown;
	}

	public void setVoteDown(int voteDown) {
		this.voteDown = voteDown;
	}

	@Column(name = "flag")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "lat")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Column(name = "lng")
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Transient
	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	@Transient
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

}
