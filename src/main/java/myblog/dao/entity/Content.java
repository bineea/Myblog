package myblog.dao.entity;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import myblog.common.entity.StringUUIDEntity;
import myblog.dao.entity.dict.ContentStatus;

@Entity
@Table(name = "blog_content")
public class Content extends StringUUIDEntity {

	private String title;// 标题
	private String text;// 内容
	private String summany;// 摘要
	private boolean markdownEnable;// 是否启用markdown
	private Blob cover;// 封面
	private ContentStatus contentStatus;// 文章状态
	private int voteUp;// “顶”的数量
	private int commentCount;// 评论数量
	private int viewCount;// 访问量
	private LocalDateTime createTime;// 创建时间
	private LocalDateTime updateTime;// 更新时间
	private String flag;// 标识
	private Double lat;// 纬度
	private Double lng;// 经度

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "summany")
	public String getSummany() {
		return summany;
	}

	public void setSummany(String summany) {
		this.summany = summany;
	}

	@Column(name = "markdown_enable")
	public boolean isMarkdownEnable() {
		return markdownEnable;
	}

	public void setMarkdownEnable(boolean markdownEnable) {
		this.markdownEnable = markdownEnable;
	}

	@Column(name = "cover")
	public Blob getCover() {
		return cover;
	}

	public void setCover(Blob cover) {
		this.cover = cover;
	}
	
	@Column(name = "content_status")
	public ContentStatus getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(ContentStatus contentStatus) {
		this.contentStatus = contentStatus;
	}

	@Column(name = "vote_up")
	public int getVoteUp() {
		return voteUp;
	}

	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}

	@Column(name = "comment_count")
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Column(name = "view_count")
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "create_time")
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time")
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
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
