package myblog.model.acl;

import java.util.ArrayList;
import java.util.List;

import myblog.dao.entity.AppResource;
import myblog.model.BaseModel;

/**
 * 角色所拥有的菜单
 */
public class MenuModel extends BaseModel {

	private boolean column = false;// 是否为栏目
	private AppResource resource;// 菜单资源
	private List<MenuModel> columnMenu = new ArrayList<>();

	public boolean isColumn() {
		return column;
	}

	public void setColumn(boolean column) {
		this.column = column;
	}

	public AppResource getResource() {
		return resource;
	}

	public void setResource(AppResource resource) {
		this.resource = resource;
	}

	public List<MenuModel> getColumnMenu() {
		return columnMenu;
	}

	public void setColumnMenu(List<MenuModel> columnMenu) {
		this.columnMenu = columnMenu;
	}

}
