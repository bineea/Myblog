package myblog.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import myblog.common.entity.StringUUIDEntity;
import myblog.model.MyFinals;

@Entity
@Table(name = "blog_user")
public class User extends StringUUIDEntity {

	public static final String DEFAULT_PWD = "123456";
	@NotNull
	@Size(max = 50, message = "{userName.error}")
	private String name;
	private String namePy;
	@NotNull
	private Boolean male;
	@Email
	private String email;
	@NotNull
	@Pattern(regexp = MyFinals.mobileRegexp, message = "手机号码格式有误")
	private String mobile;
	private String tel;
	@NotNull
	@Size(max = 20, message = "登录名长度不能超过20")
	private String loginName;
	private String passwd;
	private UserStatus status = UserStatus.NORMAL;
	private Role role;

	// 非持久化
	private String roleId;
	private String oldPasswd;// 老密码
	private String confirm_pw;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePy() {
		return namePy;
	}

	public void setNamePy(String namePy) {
		this.namePy = namePy;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public enum UserStatus {
		NORMAL("正常") {
		},
		INVALID("禁用") {
		};

		private String value;

		private UserStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
}
