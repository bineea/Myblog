package myblog.web;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.User;
import myblog.manager.LoginHelper;
import myblog.manager.acl.RoleResourceManager;
import myblog.manager.acl.UserManager;
import myblog.model.MyFinals;
import myblog.model.MySession;
import myblog.model.acl.UserInfoModel;

@Controller
public class LoginController 
{
	@Autowired
	private UserManager userManager;
	@Autowired
	private RoleResourceManager roleResourceManager;
	
	@RequestMapping(value="/common/login",method=RequestMethod.GET)
	public String setupForm(HttpServletRequest request, HttpServletResponse response, Model model, 
			@ModelAttribute("userInfoModel") UserInfoModel userInfoModel) throws IOException
	{
		if(LoginHelper.alreadyLogin(request))
		{
			String uri = (String) WebUtils.getSessionAttribute(request, MySession.LAST_URI);
			if(!StringUtils.hasText(uri) || uri.startsWith("/app/common/login"))
				return "redirect:/app/index?myMenuId=index" ;
			WebUtils.setSessionAttribute(request, MySession.LAST_URI, null);
			return "redirect:" + uri;
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies)
		{
			if(MyFinals.COOKIE_USER.equals(cookie.getName()))
				model.addAttribute("loginName", StringUtils.hasText(cookie.getValue()) ? new String(Base64.getDecoder().decode(cookie.getValue()), "utf-8") : null);
		}
		return "login";
	}
	
	@RequestMapping(value="/common/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, 
			@ModelAttribute("userInfoModel") UserInfoModel userInfoModel) throws MyManagerException, IOException
	{
		User user = userManager.toLogin(userInfoModel);
		LoginHelper.addLoginSession(request, user, roleResourceManager.getRoleMenuList(user.getRole().getId()));
		if(userInfoModel.isRememberMe())
			LoginHelper.addLoginCookie(user.getLoginName(), response);
		String lastUri = (String) WebUtils.getSessionAttribute(request, MySession.LAST_URI);
		if(!StringUtils.hasText(lastUri) || lastUri.startsWith("/app/common/welcome"))
			return "index";
		WebUtils.setSessionAttribute(request, MySession.LAST_URI, null);
		return "redirect:" + lastUri;
	}
}
