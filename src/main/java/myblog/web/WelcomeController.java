package myblog.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController 
{
	@Value("databaseProperties.name")
	private String name;
	
	@RequestMapping(value="/common/welcome", method=RequestMethod.GET)
	public String setupForm(HttpServletRequest request, Model model)
	{
		System.out.println("«Î«Ûwelcome“≥√Ê");
		System.out.println("name");
		return "welcome";
	}
}
