package myblog.dao.entity.dict;

public enum CommentStatus {
	
	NORMAL("正常"){},
	DELETE("删除"){},
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
