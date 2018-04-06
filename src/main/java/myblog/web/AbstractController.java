package myblog.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import myblog.common.pub.CommonAbstract;
import myblog.common.pub.MyManagerException;
import myblog.common.tools.HttpResponseHelper;
import myblog.model.NoteModel;

public abstract class AbstractController extends CommonAbstract {
	
	private static final String HEADER_NOTE = "header_note";
	private static final String HEADER_ERROR = "header_error";

	public void addSuccess(HttpServletResponse response, String message) throws IOException {
		logger.debug("success:{}", message);
		response.setHeader(HEADER_NOTE, Base64Utils.encodeToString(message.getBytes()));
	}
	
	@ExceptionHandler(value = MyManagerException.class)
	public void handleMyManagerException(MyManagerException e, HttpServletResponse response) throws IOException {
		logger.debug("handle MyManagerException:{}", e.getMessage());
		NoteModel model = new NoteModel(false, e.getMessage());
		jsonResponse(HEADER_ERROR, model.toJson(), response);
	}
	
	private void jsonResponse(String header, String msg, HttpServletResponse response) throws IOException
	{
		response.setHeader(header, Base64Utils.encodeToString(header.getBytes()));
		HttpResponseHelper.responseJson(msg, response);
	}
	
}
