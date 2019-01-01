package myblog.model.article;

import myblog.dao.entity.Category;
import myblog.model.BaseModel;

public class CategoryModel extends BaseModel {

	private Category category;
	private int contentSum;
	
	public CategoryModel(Category category, int contentSum) {
		this.category = category;
		this.contentSum = contentSum;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getContentSum() {
		return contentSum;
	}

	public void setContentSum(int contentSum) {
		this.contentSum = contentSum;
	}

}
