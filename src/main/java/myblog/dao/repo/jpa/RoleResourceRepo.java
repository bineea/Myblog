package myblog.dao.repo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import myblog.dao.entity.RoleResource;

public interface RoleResourceRepo extends JpaRepository<RoleResource, String>, JpaSpecificationExecutor<RoleResource> {

	@Query(value = "select r from RoleResource r where r.role.id = ?1")
	List<RoleResource> findByRoleId(String roleId);
}
