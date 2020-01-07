package com.gisinfo.sand.login;


import com.gisinfo.sand.core.auth.impl.User;
import com.gisinfo.sand.core.exception.exception.LoginException;
import com.gisinfo.sand.core.log.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    /**
     *
     * @param userId 该参数是为了让日志获取到，否则登出之后，无法获取到登出的是谁
     */
    @Log("用户登出")
    public void logout(String userId){
        SecurityUtils.getSubject().logout();
    }

    @Log("用户登录")
    public User login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        try{
            subject.login(token);
        }catch (Exception e){
            throw new LoginException("用户名或密码不正确");
        }
        user = (User) subject.getPrincipal();
        return user;
    }
}
