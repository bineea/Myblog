package myblog.manager.article;

import org.springframework.data.domain.Page;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.repo.Spe.BlogContentCatePageSpe;

public interface ContentCateManager {

	/**
	 * blog分页查询
	 * @param spe
	 * @return
	 */
	Page<ContentCategoryMapping> blogPageQuery(BlogContentCatePageSpe spe);
}
