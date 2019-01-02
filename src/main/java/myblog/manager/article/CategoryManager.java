package myblog.manager.article;

import java.util.List;

import myblog.dao.entity.Category;

public interface CategoryManager {

	/**
	 * 查询所有类别数据
	 * @return
	 */
	List<Category> findAll();
	
	/**
	 * 通过id查询类别数据
	 * @param id
	 * @return
	 */
	Category findById(String id);
}
