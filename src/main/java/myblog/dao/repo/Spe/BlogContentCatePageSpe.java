package myblog.dao.repo.Spe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.dao.entity.dict.ContentStatus;

public class BlogContentCatePageSpe extends AbstractPageSpecification<ContentCategoryMapping>{

	private String categoryId;
	private String keywords;
	private List<ContentStatus> contentStatuses;
	
	@Override
	public Specification<ContentCategoryMapping> handleSpecification() {
		Specification<ContentCategoryMapping> spe = (root, query, criteriaBuilder) -> {
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if(StringUtils.hasText(categoryId))
				predicateList.add(criteriaBuilder.equal(root.get("category.id").as(String.class), categoryId));
			if(StringUtils.hasText(keywords))
				predicateList.add(criteriaBuilder.or(criteriaBuilder.like(root.get("content.title").as(String.class), like(keywords)), criteriaBuilder.like(root.get("content.text").as(String.class), like(keywords))));
			if(contentStatuses != null && !contentStatuses.isEmpty())
				predicateList.add(criteriaBuilder.in(root.get("content.contentStatus")).value(contentStatuses));
			query.where(predicateList.stream().toArray(Predicate[]::new));
			query.orderBy(criteriaBuilder.desc(root.get("content.createTime").as(LocalDateTime.class)),criteriaBuilder.desc(root.get("content.id").as(String.class)));
			return query.getRestriction();
		};
		return spe;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<ContentStatus> getContentStatuses() {
		return contentStatuses;
	}

	public void setContentStatuses(List<ContentStatus> contentStatuses) {
		this.contentStatuses = contentStatuses;
	}

}
