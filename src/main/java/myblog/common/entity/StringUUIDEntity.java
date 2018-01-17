package myblog.common.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//1.��עΪ@MappedSuperclass���ཫ����һ��������ʵ���࣬��������ӳ�䵽���ݿ�������������Զ���ӳ�䵽����������ݿ��ֶ��С�
//2.��עΪ@MappedSuperclass���಻���ٱ�ע@Entity��@Tableע�⣬Ҳ����ʵ�����л��ӿڡ�
@MappedSuperclass
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
