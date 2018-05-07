package myblog.model.article;

import java.io.File;

import myblog.model.BaseModel;

public class CkeditorImageModel extends BaseModel {

	private String fileName;
	private boolean uploaded;
	private String url;
	private CkeditorImageErrorModel error;
	
	public static CkeditorImageModel initModel(File file, boolean uploaded, String message) {
		CkeditorImageModel model = new CkeditorImageModel();
		model.setFileName(file!=null?file.getName():null);
		model.setUploaded(uploaded);
		model.setUrl(file!=null?file.getAbsolutePath():null);
		CkeditorImageErrorModel errorModel = new CkeditorImageErrorModel();
		errorModel.setMessage(message);
		model.setError(errorModel);
		return model;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isUploaded() {
		return uploaded;
	}

	public void setUploaded(boolean uploaded) {
		this.uploaded = uploaded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CkeditorImageErrorModel getError() {
		return error;
	}

	public void setError(CkeditorImageErrorModel error) {
		this.error = error;
	}

}
