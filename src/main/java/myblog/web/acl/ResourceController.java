package myblog.web.acl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myblog.common.tools.JsonTools;
import myblog.manager.acl.ResourceManager;

@Controller
@RequestMapping("acl/resource")
public class ResourceController {
	
	@Autowired
	private ResourceManager manager;
	private final String prefix = "acl/resource/";

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet(Model model) throws IOException {
		
		model.addAttribute("rootMenu", JsonTools.writeValueAsString(manager.findRootMenu()));
		return prefix + "manage";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public String managePost() {
		
		return prefix + "manage";
	}
}
