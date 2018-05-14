package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import myblog.dao.entity.ContentCategoryMapping;

public interface ContentCategoryRepo extends JpaRepository<ContentCategoryMapping, String> {

}
