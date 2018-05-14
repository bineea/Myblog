package myblog.manager.article;

import java.io.IOException;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.dict.ContentStatus;
import myblog.model.article.ArticleModel;

public interface ArticleManager {

	String createArticle(ArticleModel articleModel, ContentStatus status) throws MyManagerException, IOException;
}
