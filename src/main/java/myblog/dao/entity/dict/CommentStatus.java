package myblog.dao.entity.dict;

public enum CommentStatus {
	
	NORMAL("����"){},
	DELETE("ɾ��"){},
	;
	
	private String value;
	
	private CommentStatus(String value)
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
