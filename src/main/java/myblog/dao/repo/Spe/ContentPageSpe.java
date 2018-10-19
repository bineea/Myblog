package myblog.dao.repo.Spe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import myblog.dao.entity.Content;
import myblog.dao.entity.dict.ContentStatus;

public class ContentPageSpe extends AbstractPageSpecification<Content> {

	private String title;
	private String text;
	private ContentStatus contentStatus;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	@Override
	public Specification<Content> handleSpecification() {
		Specification<Content> spe = (root, query, criteriaBuilder) -> {
			List<Predicate> predicateList = new ArrayList<Predicate>();
			if(StringUtils.hasText(title))
				predicateList.add(criteriaBuilder.like(root.get("title").as(String.class), like(title)));
			if(StringUtils.hasText(text))
				predicateList.add(criteriaBuilder.like(root.get("text").as(String.class), like(text)));
			if(contentStatus != null)
				predicateList.add(criteriaBuilder.equal(root.get("contentStatus"), contentStatus));
			if(startTime != null)
				predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(LocalDateTime.class), startTime));
			if(endTime != null)
				predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(LocalDateTime.class), endTime));
			query.where(predicateList.stream().toArray(Predicate[]::new));
			query.orderBy(criteriaBuilder.desc(root.get("createTime").as(LocalDateTime.class)),criteriaBuilder.desc(root.get("id").as(String.class)));
			return query.getRestriction();
		};
		return spe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ContentStatus getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(ContentStatus contentStatus) {
		this.contentStatus = contentStatus;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

}
