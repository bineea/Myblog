package myblog.web.acl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myblog.common.tools.HttpResponseHelper;
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
	
	@RequestMapping(value = "/loadResource", method = RequestMethod.GET)
	public void loadResource(@RequestParam(value = "id") String id,HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.out.println("请求加载资源参数id为：" + id);
		if(id.equals("#"))
			HttpResponseHelper.responseJson("[{\"id\":1,\"text\":\"Root node\",\"children\":[{\"id\":2,\"text\":\"Child node 1\",\"children\":true},{\"id\":3,\"text\":\"Child node 2\"}]}]", response);
		else
			HttpResponseHelper.responseJson("[{\"id\":2,\"text\":\"Child node 1\",\"children\":[{\"id\":5,\"text\":\"Child node 3\",\"children\":true},{\"id\":6,\"text\":\"Child node 4\"}]}]", response);
	}
}
