package myblog.dao.repo.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import myblog.dao.entity.Content;

public interface ContentRepo extends JpaRepository<Content, String>, JpaSpecificationExecutor<Content> {

	Page<Content> findAll(Specification<Content> spec, Pageable pageable);
}
