package myblog.manager;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import myblog.common.tools.WebTools;
import myblog.dao.entity.AppResource;
import myblog.dao.entity.RoleResource;
import myblog.dao.entity.User;
import myblog.dao.repo.jpa.AppResourceRepo;
import myblog.dao.repo.jpa.RoleResourceRepo;
import myblog.model.MySession;

@Service
public class AclHandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String loginUri;
	
	@Autowired
	private AppResourceRepo resourceRepo;
	@Autowired
	private RoleResourceRepo roleResourceRepo;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = WebTools.getUri(request, false);
		if(uri.startsWith("/")) uri = uri.substring(1);
		//忽略登陆请求
		if(uri.startsWith("app/common/welcome")) return true;
		//跳转到登陆页
		RequestMethod method = RequestMethod.valueOf(request.getMethod());
		if(!LoginHelper.alreadyLogin(request)) {
			request.getSession().invalidate();
			WebUtils.setSessionAttribute(request, MySession.ERROR_MSG, "会话已失效，请重新登陆");
			if(method == RequestMethod.GET)
				WebUtils.setSessionAttribute(request, MySession.LAST_URI, WebTools.getUri(request, true));
			response.sendRedirect(getLoginUri(request));
			return false;
		}
		//校验权限
		
//		将 角色对应资源进行缓存
		User loginUser = LoginHelper.getLoginUser(request);
		AppResource resource = resourceRepo.findByUrlMethod(uri, method);
		
		List<RoleResource> roleResourceList = roleResourceRepo.findByRoleId(loginUser.getRole().getId());
		
		return true;
	}
	
	private String getLoginUri(HttpServletRequest request) {
		if(!StringUtils.hasText(loginUri))
			loginUri = request.getContextPath() + "";
		int ran = new Random().nextInt(10);
		return loginUri + "?ran=" + ran;
	}
}
