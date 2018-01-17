package myblog.common.repo.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import myblog.common.entity.BaseEntity;

@NoRepositoryBean
public interface MyRespository  <T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
