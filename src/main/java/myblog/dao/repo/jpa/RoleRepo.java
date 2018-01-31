package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import myblog.dao.entity.Role;

public interface RoleRepo extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {

}
