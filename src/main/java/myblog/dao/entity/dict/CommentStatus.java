package myblog.dao.entity.dict;

public enum CommentStatus {
	
	NORMAL("Õý³£"){},
	DELETE("É¾³ý"){},
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
