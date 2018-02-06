package myblog.web;

import java.io.IOException;

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

import myblog.dao.entity.User;
import myblog.manager.LoginHelper;
import myblog.manager.acl.UserManager;
import myblog.model.MyFinals;
import myblog.model.MySession;
import myblog.model.acl.UserInfoModel;

@Controller
public class LoginController 
{
	@Autowired
	private UserManager userManager;
	
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
				model.addAttribute("loginName", cookie.getValue());
		}
		return "login";
	}
	
	@RequestMapping(value="/common/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, 
			@ModelAttribute("userInfoModel") UserInfoModel userInfoModel)
	{
		User user = userManager.toLogin(userInfoModel);
//		addLoginSession(request, user,);
		return "index";
	}
}
