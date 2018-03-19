package myblog.model.acl;

import myblog.dao.entity.AppResource;
import myblog.dao.entity.dict.TreeState;
import myblog.model.BaseModel;

/**
 * @author Administrator jstree 资源树
 */
public class ResourceTreeModel extends BaseModel {

	private String id;
	private String icon;
	private Object data;
	private String text;
	private TreeState state;
	private String type = "default";
	private Object children;
	
	public static ResourceTreeModel initModel(AppResource resource)
	{
		ResourceTreeModel model = new ResourceTreeModel();
		model.setId(resource.getId());
		model.setText(resource.getName());
		model.setData(resource.getMenuType().name());
		return model;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TreeState getState() {
		return state;
	}

	public void setState(TreeState state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getChildren() {
		return children;
	}

	public void setChildren(Object children) {
		this.children = children;
	}

}
