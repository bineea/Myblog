package myblog.dao.entity.dict;

public enum ContentModule {
	
	ARTICLE("����"){},
	;
	
	private String value;
	
	private ContentModule(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
