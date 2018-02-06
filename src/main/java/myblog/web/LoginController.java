package myblog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.model.acl.UserInfoModel;

@Controller
public class LoginController 
{
	
	@RequestMapping(value="/common/login",method=RequestMethod.GET)
	public String setupForm(HttpServletRequest request, @ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model)
	{
		
		return "login";
	}
	
	@RequestMapping(value="/common/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, @ModelAttribute("userInfoModel") UserInfoModel userInfo, 
			HttpServletResponse response, Model model)
	{
		
		return "index";
	}
}
