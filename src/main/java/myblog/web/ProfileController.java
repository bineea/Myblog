package myblog.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.User;
import myblog.manager.LoginHelper;
import myblog.manager.acl.UserManager;
import myblog.model.acl.UserInfoModel;

/**
 * @author Administrator
 * 个人信息
 */
@Controller
public class ProfileController extends AbstractController {
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/modPasswd", method = RequestMethod.GET)
	public String modPasswdGet(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model) {
		
		return "modPasswd";
	}
	
	@RequestMapping(value = "/modPasswd", method = RequestMethod.POST)
	public void modPasswdPost() {
		
	}
	
	@RequestMapping(value = "/modProfile", method = RequestMethod.GET)
	public String modProfileGet(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model,
			HttpServletRequest request) {
		User user = LoginHelper.getLoginUser(request);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("male", user.getMale());
		model.addAttribute("profilePic", user.getProfilePicture());
		return "modProfile";
	}
	
	@RequestMapping(value = "/modProfile", method = RequestMethod.POST)
	public void modProfilePost(@ModelAttribute("userInfoModel") UserInfoModel userInfoModel, Model model,
			HttpServletResponse response) throws MyManagerException, IOException {
		userManager.updateProfile(userInfoModel);
//		NonContextualLobCreator.INSTANCE.createBlob(file.getBytes());
		addSuccess(response, "");
	}
	
	@RequestMapping(value = "/modProfilePic", method = RequestMethod.POST)
	public void modProfilePic(@RequestParam("userId") String userId, @RequestParam("profilePic") MultipartFile profilePic, 
			Model model, HttpServletResponse response) throws MyManagerException, IOException {
//		userManager.updateProfile(userInfoModel);
//		NonContextualLobCreator.INSTANCE.createBlob(file.getBytes());
		addSuccess(response, "成功修改头像");
	}
}
