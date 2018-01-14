package myblog.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import myblog.common.entity.StringUUIDEntity;

@Entity
@Table(name = "blog_user")
public class User extends StringUUIDEntity{

	
}
