package com.gisinfo.sand.login;

import com.gisinfo.sand.core.auth.IUserService;
import com.gisinfo.sand.core.auth.impl.User;
import com.gisinfo.sand.core.exception.exception.LoginException;
import com.gisinfo.sand.core.kaptcha.CaptchaService;
import com.gisinfo.sand.core.token.TokenService;
import com.gisinfo.sand.core.web.SandContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Profile("token")
@Api(tags = "1", description = "登录管理", value = "登录管理")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CaptchaService captchaService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ApiOperation(value = "获取TOKEN")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名",required =true,paramType="form"),
            @ApiImplicitParam(name = "password", value = "密码",required =true,paramType="form"),
            @ApiImplicitParam(name = "captcha", value = "验证码",required =true,paramType="form"),
            @ApiImplicitParam(name = "key", value = "密码",required =true,paramType="form"),
    })
    public String login(String username, String password,String captcha ,String key){
        User user = new User();
        user.setLoginName(username);
        user.setPassword(password);
        user = loginService.login(user);
        String auth = SandContext.getValueFromGroup("system","default","auth");
        if("true".equals(auth)
                &&!captcha.equals(captchaService.getCacheToken(key))) throw new LoginException("验证码不正确");
        captchaService.disableCaptcha(key);
        String newToken = tokenService.generateToken(user.getLoginName());
        tokenService.setCacheToken(tokenService.getTokenHead()+newToken);
        return tokenService.getTokenHead()+newToken;
    }

    @RequestMapping(value ="/logout", method = RequestMethod.POST)
    @ApiOperation(value = "退出登录")
    public void logout(HttpServletRequest httpServletRequest){
        String authHeader = httpServletRequest.getHeader(tokenService.TOKEN_AUTHORIZATION);
        loginService.logout(userService.getCurrentUserObject().getLoginName());
        tokenService.disableToken(authHeader);
    }
}