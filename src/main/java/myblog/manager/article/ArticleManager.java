package myblog.manager.article;

import java.io.IOException;

import org.springframework.data.domain.Page;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.Content;
import myblog.dao.entity.dict.ContentStatus;
import myblog.dao.repo.Spe.ContentPageSpe;
import myblog.model.article.ArticleModel;

public interface ArticleManager {

	/**
	 * 创建文章
	 * @param articleModel
	 * @param status
	 * @return
	 * @throws MyManagerException
	 * @throws IOException
	 */
	String createArticle(ArticleModel articleModel, ContentStatus status) throws MyManagerException, IOException;
	
	/**
	 * 分页查询
	 * @param spe
	 * @return
	 */
	Page<Content> pageQuery(ContentPageSpe spe);
}
