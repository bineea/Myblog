package myblog.common.repo.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import myblog.common.entity.BaseEntity;

public interface MyRespository  <T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
