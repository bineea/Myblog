package myblog.dao.repo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myblog.dao.entity.ContentCategoryMapping;
import myblog.model.article.CategoryModel;

public interface ContentCategoryRepo extends JpaRepository<ContentCategoryMapping, String> {

	@Query(value = "select new CategoryModel(category, sum(id)) from ContentCategoryMapping group by category")
	List<CategoryModel> countContentByCategory();
}
