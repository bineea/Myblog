package myblog.manager.acl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.AppResource.MenuType;
import myblog.dao.repo.jpa.AppResourceRepo;

@Service   
public class ResourceManagerImpl implements ResourceManager {

	@Autowired
	private AppResourceRepo resourceRepo;
	
	@Override
	public List<AppResource> findRootMenu() {
		List<AppResource> resourceList = resourceRepo.findByMenuType(MenuType.COLUMN).stream()
														.filter(resource -> !StringUtils.hasText(resource.getMenuId()))
														.sorted(new Comparator<AppResource>() {
															
															@Override
															public int compare(AppResource res1, AppResource res2) {
																return res1.getList().compareTo(res2.getList());
															}
														})
														.collect(Collectors.toList());
		return resourceList;
	}

	@Override
	public List<AppResource> listByParent(String menuId) {
		
		List<AppResource> resourceList = resourceRepo.findByMenuId(menuId);
		return resourceList;
	}

}
