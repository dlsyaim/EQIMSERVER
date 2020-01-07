package com.gisinfo.sand.user;

import com.gisinfo.sand.core.auth.IUser;
import com.gisinfo.sand.core.auth.IUserService;
import com.gisinfo.sand.core.token.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "3", description = "用户管理", value = "用户管理")
public class UserController  {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/info", method = RequestMethod.POST,headers = {TokenService.TOKEN_AUTHORIZATION})
    @ApiOperation(value = "获取当前用户信息")
    public IUser user(){
        return userService.getCurrentUserObject();
    }
}
