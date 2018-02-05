package myblog.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.model.acl.UserInfoModel;

@Controller
public class LoginController 
{
	@RequestMapping(value="/common/login",method=RequestMethod.GET)
	public String setupForm(HttpServletRequest request, UserInfoModel userInfo, Model model)
	{
		
		return "index";
	}
	
	@RequestMapping(value="/common/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, UserInfoModel userInfo, Model model)
	{
		return "";
	}
}
