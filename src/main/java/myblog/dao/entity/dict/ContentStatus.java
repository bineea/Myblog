package myblog.dao.entity.dict;

public enum ContentStatus {

	TEMPORARY("未发布","暂存"){},
	NORMAL("已发布","正常"){},
	FORBIDCOMMENT("已发布","禁止评论"){},
	TOP("已发布","置顶"){},
	;
	
	private String publishValue;
	private String statusValue;
	
	private ContentStatus(String publishValue, String statusValue) {
		
		this.publishValue = publishValue;
		this.statusValue = statusValue;
	}

	public String getPublishValue() {
		return publishValue;
	}

	public void setPublishValue(String publishValue) {
		this.publishValue = publishValue;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	
}
