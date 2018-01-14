package myblog.dao.entity.dict;

public enum CommentType {

	COMMENT("ÆÀÂÛ") {},
	REPLY("»Ø¸´") {},
	;

	private String value;

	private CommentType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
