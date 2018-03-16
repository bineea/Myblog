package myblog.web.acl;

import java.io.IOException;
import java.util.List;

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
import myblog.model.acl.ResourceTreeModel;
import myblog.web.AbstractController;

@Controller
@RequestMapping("acl/resource")
public class ResourceController extends AbstractController {
	
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
		List<ResourceTreeModel> treeList = manager.getResourceTree(id);
		HttpResponseHelper.responseJson(JsonTools.writeValueAsString(treeList), response);
	}
}
