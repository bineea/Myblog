package myblog.manager.article;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.NonContextualLobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.Category;
import myblog.dao.entity.Content;
import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.entity.dict.ContentStatus;
import myblog.dao.repo.Spe.ContentPageSpe;
import myblog.dao.repo.jpa.CategoryRepo;
import myblog.dao.repo.jpa.ContentCategoryRepo;
import myblog.dao.repo.jpa.ContentRepo;
import myblog.manager.AbstractManager;
import myblog.model.article.ArticleModel;

@Service
public class ArticleManagerImpl extends AbstractManager implements ArticleManager {

	@Autowired
	private ContentCategoryRepo contentCategoryRepo;
	@Autowired
	private ContentRepo contentRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Transactional
	@Override
	public String createArticle(ArticleModel articleModel, ContentStatus status) throws MyManagerException, IOException {
		validateArticle(articleModel);
		Content con = getContentByArticleModel(articleModel, status);
		List<ContentCategoryMapping> contentCateList = getContentCategory(con, articleModel.getCategoryIds());
		contentRepo.save(con);
		contentCategoryRepo.saveAll(contentCateList);
		return con.getId();
	}
	
	private Content getContentByArticleModel(ArticleModel articleModel, ContentStatus status) throws IOException {
		Content content = new Content();
		content.setTitle(articleModel.getCover() != null ? new String(articleModel.getTitle().getBytes("ISO-8859-1"), "UTF-8") : articleModel.getTitle());
		content.setText(articleModel.getCover() != null ? new String(articleModel.getText().getBytes("ISO-8859-1"), "UTF-8") : articleModel.getText());
		content.setSummany(articleModel.getCover() != null ? new String(articleModel.getSummany().getBytes("ISO-8859-1"), "UTF-8") : articleModel.getSummany());
		content.setCover(articleModel.getCover() != null ? NonContextualLobCreator.INSTANCE.createBlob(articleModel.getCover().getBytes()) : null);
		content.setMarkdownEnable(articleModel.isMarkdownEnable());
		content.setContentStatus(status);
		content.setCreateTime(LocalDateTime.now());
		content.setUpdateTime(LocalDateTime.now());
		return content;
	}
	
	private List<ContentCategoryMapping> getContentCategory(Content content, List<String> categoryIds) {
		List<ContentCategoryMapping> contentCategoryList = new ArrayList<ContentCategoryMapping>();
		categoryIds.stream().forEach(id -> {
			Optional<Category> categoryOptional = categoryRepo.findById(id);
			if(categoryOptional.isPresent())
			{
				ContentCategoryMapping map = new ContentCategoryMapping();
				map.setContent(content);
				map.setCategory(categoryOptional.get());
				contentCategoryList.add(map);
			}
		});
		return contentCategoryList;
	}
	
	private void validateArticle(ArticleModel articleModel) throws MyManagerException {
		if(!StringUtils.hasText(articleModel.getTitle()))
			throw new MyManagerException("文章标题不能为空");
		if(!StringUtils.hasText(articleModel.getText()))
			throw new MyManagerException("文章内容不能为空");
		if(!StringUtils.hasText(articleModel.getSummany()))
			throw new MyManagerException("文章摘要不能为空");
		if(CollectionUtils.isEmpty(articleModel.getCategoryIds()))
			throw new MyManagerException("文章类别不能为空");
		for(String id:articleModel.getCategoryIds()) {
			Optional<Category> categoryOptional = categoryRepo.findById(id);
			if(!categoryOptional.isPresent())
				throw new MyManagerException("文章类别不存在");
		}
	}

	@Override
	public Page<Content> pageQuery(ContentPageSpe spe) {
		Assert.notNull(spe, "contentPageSpe不能为NULL");
		return contentRepo.findAll(spe.handleSpecification(), spe.getPageRequest());
	}
}
