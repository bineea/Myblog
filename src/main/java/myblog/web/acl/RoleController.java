package myblog.web.acl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myblog.common.pub.MyManagerException;
import myblog.common.tools.JsonTools;
import myblog.dao.entity.Role;
import myblog.dao.entity.User;
import myblog.dao.repo.Spe.RolePageSpe;
import myblog.manager.LoginHelper;
import myblog.manager.acl.RoleManager;
import myblog.model.acl.ResourceTreeModel;
import myblog.web.AbstractController;

@Controller
@RequestMapping(value = "acl/role")
public class RoleController extends AbstractController {
	
	@Autowired
	private RoleManager manager;

	private static final String prefix = "acl/role/";
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet(@ModelAttribute("queryModel") RolePageSpe pageSpe, Model model) {
		return prefix + "manage";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public String managePost(@ModelAttribute("queryModel") RolePageSpe pageSpe, Model model) {
		Page<Role> page = manager.pageQuery(pageSpe);
		model.addAttribute("queryResult", page.getContent());
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalElements", page.getTotalElements());
		return prefix + "queryResult";
	}
	
	@RequestMapping(value = "/configRole/{id}", method = RequestMethod.GET)
	public String configGet(@PathParam("id") String id, HttpServletRequest request, Model model) throws IOException {
		User user = LoginHelper.getLoginUser(request);
		List<ResourceTreeModel> treeList = manager.getAllResource(user.getRole().getId());
		model.addAttribute("treeJson", JsonTools.writeValueAsString(treeList));
		model.addAttribute("roleId", user.getRole().getId());
		return prefix + "conf";
	}
	
	@RequestMapping(value = "/configRole", method = RequestMethod.POST)
	public void configPost(
			@RequestParam("roleId") String roleId,
			@RequestParam("resourceIds") String[] resourceIds,
			Model model, HttpServletResponse response) throws IOException, MyManagerException {
		manager.configRole(roleId, resourceIds);
		addSuccess(response, "成功配置资源");
	}
}
