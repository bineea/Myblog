package myblog.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import myblog.common.tools.JsonTools;
import myblog.dao.entity.User;
import myblog.model.MySession;

public class LoginHelper {

	private static Logger logger = LoggerFactory.getLogger(LoginHelper.class);

	public static boolean alreadyLogin(HttpServletRequest request) {
		User loginUser = getLoginUser(request);
		return (loginUser != null && StringUtils.hasText(loginUser.getId()));
	}

	public static User getLoginUser(HttpServletRequest request) {
		try {
			String loginUser = (String) WebUtils.getSessionAttribute(request, MySession.LOGIN_USER);
			if (StringUtils.hasText(loginUser))
				return JsonTools.json2Object(loginUser, User.class);
		} catch (IOException e) {
			logger.error("获取登陆用户信息异常，异常信息：{}", e);
		}
		return null;
	}
}
