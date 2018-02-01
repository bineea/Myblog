package myblog.model.acl;

import java.util.ArrayList;
import java.util.List;

import myblog.dao.entity.dict.ResourceType;
import myblog.model.BaseModel;


/**
 * 角色所拥有的菜单
 */
public class RoleMenuModel extends BaseModel
{
	private ResourceType type;// 资源分类
	private List<ColumnMenuModel> columnMenus = new ArrayList<ColumnMenuModel>();

	public ResourceType getType()
	{
		return type;
	}

	public void setType(ResourceType type)
	{
		this.type = type;
	}

	public List<ColumnMenuModel> getColumnMenus()
	{
		return columnMenus;
	}

	public void setColumnMenus(List<ColumnMenuModel> columnMenus)
	{
		this.columnMenus = columnMenus;
	}

}

