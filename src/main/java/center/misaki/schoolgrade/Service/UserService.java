package center.misaki.schoolgrade.Service;


public interface UserService {

    //处理登录是否成功
    boolean isLoginSuccess(String username, String password);

    //返回登录的角色是啥
    String roleGet(String username);

}
