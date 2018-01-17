package myblog.common.repo.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import myblog.common.entity.BaseEntity;

@NoRepositoryBean
public class MyRespositoryImpl<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRespository<T, ID>{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	private final EntityManager entityManager;
	
	public MyRespositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}
	
	public MyRespositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

}
