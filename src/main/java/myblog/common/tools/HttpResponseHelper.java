package myblog.common.tools;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpResponseHelper {

	protected static Logger logger = LoggerFactory.getLogger(HttpResponseHelper.class);

	public static void responseJson(String jsonStr, final HttpServletResponse response) throws IOException
	{
		setJsonResponseHeader(response);
		response.getWriter().print(jsonStr);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 会根据客户端判断是否支持gzip而启动gzip
	 * 
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void responseJson(String jsonStr, HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		boolean supportGzip = isClientSupportGzip(request);
		if (supportGzip) response.setHeader("Content-Encoding", "gzip");
		PrintWriter writer = supportGzip
				? new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new GZIPOutputStream(response.getOutputStream()), "UTF-8")))
				: response.getWriter();
		setJsonResponseHeader(response);
		writer.print(jsonStr);
		writer.close();
	}

	private static boolean isClientSupportGzip(HttpServletRequest request)
	{
		String headEncoding = request.getHeader("Accept-Encoding");
		boolean supportGzip = headEncoding != null && (headEncoding.toLowerCase().indexOf("gzip") != -1);
		return supportGzip;
	}

	private static void setJsonResponseHeader(HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Expires", "0");
		response.setContentType("application/json");
	}
}
