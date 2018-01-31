package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.dao.entity.AppResource;

public interface AppResourceRepo extends JpaRepository<AppResource, String>, JpaSpecificationExecutor<AppResource> {

	@Query(value = "select a from AppResource a where a.url = ?1 and a.requestMethod = ?2")
	AppResource findByUrlMethod(String url, RequestMethod requestMethod);
}
