package myblog.model.article;

import myblog.dao.entity.Category;
import myblog.model.BaseModel;

public class CategoryModel extends BaseModel {

	private Category category;
	private long contentSum;
	
	public CategoryModel(Category category, long contentSum) {
		this.category = category;
		this.contentSum = contentSum;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getContentSum() {
		return contentSum;
	}

	public void setContentSum(long contentSum) {
		this.contentSum = contentSum;
	}

}
