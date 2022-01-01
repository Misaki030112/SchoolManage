package center.misaki.schoolgrade.Service.Impl;

import center.misaki.schoolgrade.Dao.SysUserDao;
import center.misaki.schoolgrade.Pojo.SysUser;
import center.misaki.schoolgrade.Service.UserService;
import center.misaki.schoolgrade.Utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserDao sysUserDao;



    @Override
    public boolean isLoginSuccess(String username, String password) {
        SysUser byUsername = sysUserDao.findByUsername(username);
        if(byUsername==null){
            return false;
        }
        boolean b = MD5Util.passwordIsTrue(password, byUsername.getPassword());
        return b;
    }

    @Override
    public String roleGet(String username) {
        SysUser byUsername = sysUserDao.findByUsername(username);
        if(byUsername.getRoleId()==1){
            return "Teacher";
        }
        if(byUsername.getRoleId()==2){
            return "Student";
        }
        if(byUsername.getRoleId()==3){
            return "Admin";
        }
        return "null";
    }
}
