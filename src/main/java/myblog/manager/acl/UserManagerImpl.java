package myblog.manager.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import myblog.common.pub.MyManagerException;
import myblog.common.pub.MyViolationException;
import myblog.common.tools.SecurityTools;
import myblog.common.tools.SecurityTools.DigestType;
import myblog.dao.entity.User;
import myblog.dao.entity.User.UserStatus;
import myblog.dao.repo.jpa.UserRepo;
import myblog.manager.AbstractManager;
import myblog.model.acl.UserInfoModel;

@Service
public class UserManagerImpl extends AbstractManager implements UserManager {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User toLogin(UserInfoModel userInfoModel) throws MyManagerException {
		
		if(!StringUtils.hasText(userInfoModel.getLoginName()))
			throw new MyViolationException("loginName", "账号不能为空");
		if(!StringUtils.hasText(userInfoModel.getPasswd()))
			throw new MyViolationException("passwd", "密码不能为空");
		String passwd = SecurityTools.encryStr(userInfoModel.getPasswd(), DigestType.SHA_1);
		User user = userRepo.findByLoginNamePasswd(userInfoModel.getLoginName(), passwd);
		if(user == null)
			throw new MyManagerException("账号与密码不匹配");
		if(user.getStatus() != UserStatus.NORMAL)
			throw new MyManagerException("该用户已停用");
		return user;
	}

}