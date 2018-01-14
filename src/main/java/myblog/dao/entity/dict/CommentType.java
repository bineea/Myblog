package myblog.dao.entity.dict;

public enum CommentType {

	COMMENT("����") {},
	REPLY("�ظ�") {},
	;

	private String value;

	private CommentType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
