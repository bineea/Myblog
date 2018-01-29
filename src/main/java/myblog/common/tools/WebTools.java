package myblog.common.tools;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

public class WebTools extends WebUtils {

	public static String getUri(HttpServletRequest request, boolean withParams) {
		String uri = request.getServletPath();
		
		return uri;
	}
}
