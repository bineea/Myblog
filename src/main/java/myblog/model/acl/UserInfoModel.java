package myblog.model.acl;

import myblog.dao.entity.Role;
import myblog.dao.entity.User.UserStatus;
import myblog.model.BaseModel;

public class UserInfoModel extends BaseModel {

	private String name;
	private Boolean male;
	private String email;
	private String loginName;// 账号（字母+数字）
	private String passwd;
	private UserStatus status = UserStatus.NORMAL;
	private Role role;
	private String roleId;
	private String oldPasswd;// 老密码
	private String confirm_pw;// 确认密码

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getMale() {
		return male;
	}

	public void setMale(Boolean male) {
		this.male = male;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOldPasswd() {
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}

	public String getConfirm_pw() {
		return confirm_pw;
	}

	public void setConfirm_pw(String confirm_pw) {
		this.confirm_pw = confirm_pw;
	}

}
