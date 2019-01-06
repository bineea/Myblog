package myblog.manager.article;

import java.util.List;

import org.springframework.data.domain.Page;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.repo.Spe.BlogContentCatePageSpe;
import myblog.model.article.CategoryModel;

public interface ContentCateManager {

	/**
	 * blog分页查询
	 * @param spe
	 * @return
	 */
	Page<ContentCategoryMapping> blogPageQuery(BlogContentCatePageSpe spe);
	
	/**
	 * 分类下的文章统计
	 * @return
	 */
	List<CategoryModel> categoryStatistic();
}
