package myblog.model.article;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import myblog.model.BaseModel;

public class ArticleModel extends BaseModel {
	private String title;// 标题
	private String text;// 内容
	private boolean markdownEnable;// 是否启用markdown
	private MultipartFile cover;// 封面
	private List<String> categoryIds;// 类别

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isMarkdownEnable() {
		return markdownEnable;
	}

	public void setMarkdownEnable(boolean markdownEnable) {
		this.markdownEnable = markdownEnable;
	}

	public MultipartFile getCover() {
		return cover;
	}

	public void setCover(MultipartFile cover) {
		this.cover = cover;
	}

	public List<String> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<String> categoryIds) {
		this.categoryIds = categoryIds;
	}

}
