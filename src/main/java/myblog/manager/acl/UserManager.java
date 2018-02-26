package myblog.manager.acl;

import myblog.common.pub.MyManagerException;
import myblog.dao.entity.User;
import myblog.model.acl.UserInfoModel;

public interface UserManager {

	User toLogin(UserInfoModel userInfoModel) throws MyManagerException;
}
