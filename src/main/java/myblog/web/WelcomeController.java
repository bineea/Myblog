package myblog.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController 
{
	@RequestMapping(value="/common/welcome", method=RequestMethod.GET)
	public String setupForm(HttpServletRequest request, Model model)
	{
		System.out.println("访问welcome页面");
		return "index";
	}
}
