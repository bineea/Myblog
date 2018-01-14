package myblog.common.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class StringUUIDEntity extends BaseEntity {
	
	protected String id;

	@Id
	@Column(name = "id", nullable = false, length = 32)
	public String getId() {
		if (id == null) id = UUID.randomUUID().toString().replace("-", "");
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
