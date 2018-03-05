package myblog.web.acl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("acl/resource")
public class ResourceController {
	
	private final String prefix = "acl/resource/";

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet() {
		
		return prefix + "manage";
	}
}
