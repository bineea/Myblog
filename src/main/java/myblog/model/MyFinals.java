package myblog.model;

import java.util.regex.Pattern;

public class MyFinals {
	
	public static String COOKIE_USER = "mycookieuser";

//	默认分页查询页码
	public static final int DEFAULT_PAGE_NUM = 0;
//	默认分页查询单页数量
	public static final int DEFAULT_PAGE_SIZE = 27;
//	手机号码正则
	public static final String mobileRegexp = "^1[3|4|5|7|8|9]{1}[0-9]{9}$";
	public static final Pattern mobilePattern = Pattern.compile(mobileRegexp);
//	jstree请求根目录ID
	public static final String jsTreeRootReq = "#";
}
