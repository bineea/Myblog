package myblog.dao.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import myblog.dao.entity.User;

public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
