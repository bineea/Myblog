package myblog.manager.acl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import myblog.common.pub.MyManagerException;
import myblog.common.tools.SecurityTools;
import myblog.common.tools.SecurityTools.DigestType;
import myblog.dao.entity.Role;
import myblog.dao.entity.User;
import myblog.dao.entity.User.UserStatus;
import myblog.dao.repo.Spe.UserPageSpe;
import myblog.dao.repo.jpa.RoleRepo;
import myblog.dao.repo.jpa.UserRepo;
import myblog.manager.AbstractManager;
import myblog.model.MyFinals;
import myblog.model.acl.UserInfoModel;

@Service
public class UserManagerImpl extends AbstractManager implements UserManager {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public User toLogin(UserInfoModel userInfoModel) throws MyManagerException {
		
		if(!StringUtils.hasText(userInfoModel.getLoginName()))
			throw new MyManagerException("账号不能为空");
		if(!StringUtils.hasText(userInfoModel.getPasswd()))
			throw new MyManagerException("密码不能为空");
		String passwd = SecurityTools.encryStr(userInfoModel.getPasswd(), DigestType.SHA_1);
		User user = userRepo.findByLoginNamePasswd(userInfoModel.getLoginName(), passwd);
		if(user == null)
			throw new MyManagerException("账号与密码不匹配");
		if(user.getStatus() != UserStatus.NORMAL)
			throw new MyManagerException("该用户已停用");
		return user;
	}

	@Override
	public Page<User> pageQuery(UserPageSpe spe) {
		return userRepo.findAll(spe.handleSpecification(), spe.getPageRequest());
	}

	@Override
	@Transient
	public User add(UserInfoModel model) throws MyManagerException {
		userInfoValid(model);
		User user = userRepo.findByLoginName(model.getLoginName());
		if(user != null)
			throw new MyManagerException("该账号【"+model.getLoginName()+"】已存在");
		user = userRepo.findByEmail(model.getEmail());
		if(user != null)
			throw new MyManagerException("该邮箱地址【"+model.getEmail()+"】已存在");
		user = new User();
		BeanUtils.copyProperties(model, user);
		user.setPasswd(SecurityTools.encryStr(User.DEFAULT_PWD, DigestType.SHA_1));
		user.setStatus(UserStatus.NORMAL);
		userRepo.save(user);
		return user;
	}

	@Override
	public User findById(String id) {
		Assert.hasText(id, "id不能为空");
		return userRepo.findById(id).orElse(null);
	}

	@Override
	@Transient
	public User updateStatus(String id, UserStatus status) throws MyManagerException {
		User user = userRepo.findById(id).orElse(null);
		if(user == null)
			throw new MyManagerException("该用户信息不存在");
		if(user.getStatus() == status)
			throw new MyManagerException("该用户状态为【"+status.getValue()+"】，无需变更状态");
		user.setStatus(status);
		userRepo.save(user);
		return user;
	}

	@Override
	public User updateRole(String id, String roleId) throws MyManagerException {
		User user = userRepo.findById(id).orElse(null);
		if(user == null)
			throw new MyManagerException("该用户信息不存在");
		Role role = roleRepo.findById(roleId).orElse(null);
		if(role == null)
			throw new MyManagerException("该角色信息不存在");
		user.setRole(role);
		userRepo.save(user);
		return user;
	}

	@Override
	public User updateProfile(UserInfoModel model) throws MyManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePasswd(UserInfoModel model) throws MyManagerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void userInfoValid(UserInfoModel model) throws MyManagerException {
		if(!StringUtils.hasText(model.getLoginName()))
			throw new MyManagerException("账号不能为空");
		if(!StringUtils.hasText(model.getName()))
			throw new MyManagerException("昵称不能为空");
		if(!StringUtils.hasText(model.getEmail()))
			throw new MyManagerException("邮箱不能为空");
		if(!MyFinals.checkEmailFormat(model.getEmail()))
			throw new MyManagerException("邮箱格式错误");
		if(!MyFinals.checkLoginNameFormat(model.getLoginName()))
			throw new MyManagerException("账号格式错误");
		if(model.getName().length() > 25)
			throw new MyManagerException("昵称长度超长，最多25个字符");
	}

}
