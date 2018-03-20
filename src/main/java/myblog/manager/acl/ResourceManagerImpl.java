package myblog.manager.acl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.AppResource.MenuType;
import myblog.dao.repo.Spe.AppResourcePageSpe;
import myblog.dao.repo.jpa.AppResourceRepo;
import myblog.model.MyFinals;
import myblog.model.acl.ResourceTreeModel;

@Service   
public class ResourceManagerImpl implements ResourceManager {

	@Autowired
	private AppResourceRepo resourceRepo;
	
	@Override
	public List<AppResource> findRootMenu() {
		List<AppResource> resourceList = resourceRepo.findByMenuType(MenuType.COLUMN).stream()
														.filter(resource -> !StringUtils.hasText(resource.getMenuId()))
														.sorted((res1, res2) -> {
															return res1.getList().compareTo(res2.getList());
														})
														.collect(Collectors.toList());
		return resourceList;
	}

	@Override
	public List<AppResource> listByParent(String menuId) {
		
		List<AppResource> resourceList = resourceRepo.findByMenuId(menuId);
		return resourceList;
	}

	@Override
	public List<ResourceTreeModel> getResourceTree(String resourceId) {

		List<ResourceTreeModel> treeList = new ArrayList<>();
		if(MyFinals.jsTreeRootReq.equals(resourceId))
		{
			findRootMenu().stream().forEach(resource -> {
				ResourceTreeModel rootModel = ResourceTreeModel.initModel(resource);
				rootModel.setChildren(true);
				treeList.add(rootModel);
			});
		}
		else
		{
			Optional<AppResource> resourceOptional = resourceRepo.findById(resourceId);
			resourceOptional.ifPresent(resource -> {
				ResourceTreeModel rootModel = ResourceTreeModel.initModel(resource);
				List<ResourceTreeModel> childrenlList = new ArrayList<>();
				listByParent(resourceId).stream().forEach(res -> {
					ResourceTreeModel model = new ResourceTreeModel();
					model = ResourceTreeModel.initModel(res);
					if(res.getMenuType() != MenuType.COLUMN)
						model.setType("link");
					else
						model.setChildren(true);
					childrenlList.add(model);
				});
				rootModel.setChildren(childrenlList);
				treeList.add(rootModel);
			});
		}
		return treeList;
	}

	@Override
	public Page<AppResource> pageQuery(AppResourcePageSpe pageSpe) {
		return resourceRepo.findAll(pageSpe.handleSpecification(), pageSpe.getPageRequest());
	}

}
