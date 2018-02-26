package myblog.model.acl;

import java.util.List;

import myblog.dao.entity.AppResource;
import myblog.model.BaseModel;

/**
 * 角色所拥有的菜单
 */
public class MenuModel extends BaseModel {

	private boolean column = false;// 是否为栏目
	private List<MenuModel> columnMenu;
	private List<AppResource> resource;// 菜单资源

	public boolean isColumn() {
		return column;
	}

	public void setColumn(boolean column) {
		this.column = column;
	}

	public List<MenuModel> getColumnMenu() {
		return columnMenu;
	}

	public void setColumnMenu(List<MenuModel> columnMenu) {
		this.columnMenu = columnMenu;
	}

	public List<AppResource> getResource() {
		return resource;
	}

	public void setResource(List<AppResource> resource) {
		this.resource = resource;
	}

}
