package myblog.manager.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.repo.Spe.BlogContentCatePageSpe;
import myblog.dao.repo.jpa.ContentCategoryRepo;
import myblog.manager.AbstractManager;
import myblog.model.article.CategoryModel;

@Service
public class ContentCateManagerImpl extends AbstractManager implements ContentCateManager {

	@Autowired
	private ContentCategoryRepo contentCateRepo;
	
	@Override
	public Page<ContentCategoryMapping> blogPageQuery(BlogContentCatePageSpe spe) {
		Assert.notNull(spe, "spe不能为空");
		return contentCateRepo.findAll(spe.handleSpecification(), spe.getPageRequest());
	}

	@Override
	public List<CategoryModel> categoryStatistic() {
		return contentCateRepo.countContentByCategory();
	}

}
