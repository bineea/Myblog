package myblog.model.acl;

import java.util.ArrayList;
import java.util.List;

import myblog.dao.entity.AppResource;
import myblog.model.BaseModel;

/**
 * 栏目菜单
 */
public class ColumnMenuModel extends BaseModel
{
	private AppResource columnResource;// 栏目资源
	private boolean hasTabMenu;// 是否拥有标签菜单
	private List<AppResource> tabResources = new ArrayList<AppResource>();// 标签资源

	private boolean hasColumnResource;// 是否拥有本栏目菜单（角色配置时用）

	public AppResource getColumnResource()
	{
		return columnResource;
	}

	public void setColumnResource(AppResource columnResource)
	{
		this.columnResource = columnResource;
	}

	public boolean isHasTabMenu()
	{
		return hasTabMenu;
	}

	public void setHasTabMenu(boolean hasTabMenu)
	{
		this.hasTabMenu = hasTabMenu;
	}

	public List<AppResource> getTabResources()
	{
		return tabResources;
	}

	public void setTabResources(List<AppResource> tabResources)
	{
		this.tabResources = tabResources;
	}

	public boolean isHasColumnResource()
	{
		return hasColumnResource;
	}

	public void setHasColumnResource(boolean hasColumnResource)
	{
		this.hasColumnResource = hasColumnResource;
	}
}
