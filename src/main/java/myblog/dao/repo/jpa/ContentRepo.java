package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import myblog.dao.entity.Content;

public interface ContentRepo extends JpaRepository<Content, String>, JpaSpecificationExecutor<Content> {

}
