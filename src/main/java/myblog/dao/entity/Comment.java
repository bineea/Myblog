package myblog.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import myblog.common.entity.StringUUIDEntity;
import myblog.dao.entity.dict.CommentStatus;
import myblog.dao.entity.dict.CommentType;
import myblog.dao.entity.dict.ContentModule;

@Entity
@Table(name = "blog_comment")
public class Comment extends StringUUIDEntity {
	
	private Comment parentComment;//�ظ�������ID
	private Content content;//���۵�����ID
	private ContentModule contentModule;//���۵�����ģ��
	private int commentCount;//���۵Ļظ�����
	private int orderNum;//�����ţ��������ö���
	private User user;//���۵��û�ID
	private String ip;//���۵�IP��ַ
	private String author;//���۵�����
	private CommentType commentType;//���۵����ͣ�Ĭ����comment
	private String text;//���۵�����
	private String agent;//�ύ���۵��������Ϣ
	private LocalDateTime createTime;//���۵�ʱ��
	private String slug;//���۵�slug(α��̬)
	private String email;//�����û���email
	private CommentStatus status;//���۵�״̬
	private int voteUp;//������������
	private int voteDown;//���ȡ�������
	private String flag;//��ʶ
	private Double lat;//γ��
	private Double lng;//����
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	public Comment getParentComment() {
		return parentComment;
	}
	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}
	
	@ManyToOne
	@JoinColumn(name = "content_id")
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
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
}
