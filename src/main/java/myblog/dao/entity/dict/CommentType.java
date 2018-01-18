package myblog.dao.entity.dict;

public enum CommentType {

	COMMENT("评论") {},
	REPLY("回复") {},
	;

	private String value;

	private CommentType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
