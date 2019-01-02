package myblog.dao.repo.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.model.article.CategoryModel;

public interface ContentCategoryRepo extends JpaRepository<ContentCategoryMapping, String>, JpaSpecificationExecutor<ContentCategoryMapping> {

	@Query(value = "select new myblog.model.article.CategoryModel(m.category, count(m.id)) from ContentCategoryMapping m group by m.category")
	List<CategoryModel> countContentByCategory();
	
	Page<ContentCategoryMapping> findAll(Specification<ContentCategoryMapping> spec, Pageable pageable);
}
