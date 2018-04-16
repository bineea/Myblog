package myblog.manager.acl;

import org.springframework.data.domain.Page;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.User;
import myblog.dao.entity.User.UserStatus;
import myblog.dao.repo.Spe.UserPageSpe;
import myblog.model.acl.UserInfoModel;

public interface UserManager {

	/**
	 * 用户登录
	 * @param userInfoModel
	 * @return
	 * @throws MyManagerException
	 */
	User toLogin(UserInfoModel userInfoModel) throws MyManagerException;
	
	/**
	 * 分页查询
	 * @param spe
	 * @return
	 */
	Page<User> pageQuery(UserPageSpe spe);
	
	/**
	 * 添加用户
	 * @param model
	 * @return
	 */
	User add(UserInfoModel model) throws MyManagerException;
	
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	User findById(String id);
	
	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 * @return
	 * @throws MyManagerException
	 */
	User updateStatus(String id, UserStatus status) throws MyManagerException;
	
	/**
	 * 更新用户角色
	 * @param id
	 * @param roleId
	 * @return
	 * @throws MyManagerException
	 */
	User updateRole(String id, String roleId) throws MyManagerException;
	
	/**
	 * 更新用户信息
	 * @param model
	 * @return
	 * @throws MyManagerException
	 */
	User updateProfile(UserInfoModel model) throws MyManagerException;
	
	/**
	 * 修改密码
	 * @param model
	 * @return
	 * @throws MyManagerException
	 */
	User updatePasswd(UserInfoModel model) throws MyManagerException;
	
}
