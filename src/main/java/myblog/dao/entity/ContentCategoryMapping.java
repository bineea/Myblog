package myblog.dao.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import myblog.common.entity.StringUUIDEntity;

@Entity
@Table(name = "blog_content_category_mapping")
public class ContentCategoryMapping extends StringUUIDEntity {

	private Content content;// 文章
	private Category category;// 类别

	@ManyToOne
	@JoinColumn(name = "content_id")
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
