package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import myblog.dao.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {

}
