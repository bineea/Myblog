package myblog.model.article;

import myblog.model.BaseModel;

public class CkeditorImageErrorModel extends BaseModel {
	private Integer number;
	private String message;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
