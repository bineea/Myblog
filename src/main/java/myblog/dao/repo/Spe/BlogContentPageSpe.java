package myblog.dao.repo.Spe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import myblog.dao.entity.Content;
import myblog.dao.entity.dict.ContentStatus;

public class BlogContentPageSpe extends AbstractPageSpecification<Content> {

	private String keywords;
	private List<ContentStatus> contentStatuses;
	
	@Override
	public Specification<Content> handleSpecification() {
		Specification<Content> spe = (root, query, criteriaBuilder) -> {
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if(StringUtils.hasText(keywords))
				predicateList.add(criteriaBuilder.or(criteriaBuilder.like(root.get("title").as(String.class), like(keywords)), criteriaBuilder.like(root.get("text").as(String.class), like(keywords))));
			if(contentStatuses != null && !contentStatuses.isEmpty())
				predicateList.add(criteriaBuilder.in(root.get("contentStatus")).value(contentStatuses));
			query.where(predicateList.stream().toArray(Predicate[]::new));
			query.orderBy(criteriaBuilder.desc(root.get("createTime").as(LocalDateTime.class)),criteriaBuilder.desc(root.get("id").as(String.class)));
			return query.getRestriction();
		};
		return spe;
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
