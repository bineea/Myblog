package myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.model.acl.UserInfoModel;

/**
 * @author Administrator
 * 个人信息
 */
@Controller
public class ProfileController extends AbstractController {

	@RequestMapping(value = "/modPasswd", method = RequestMethod.GET)
	public String modPasswdGet(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model) {
		
		return "modPasswd";
	}
	
	@RequestMapping(value = "/modPasswd", method = RequestMethod.POST)
	public void modPasswdPost() {
		
	}
	
	@RequestMapping(value = "/modProfile", method = RequestMethod.GET)
	public String modProfileGet(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model) {
		
		return "modProfile";
	}
	
	@RequestMapping(value = "/modProfile", method = RequestMethod.POST)
	public void modProfilePost(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model) {
		System.out.println(userInfoModel.toJson());
		System.out.println(userInfoModel.getProfilePic().getSize());
	}
}
