package com.gisinfo.sand.auth;

import com.gisinfo.platform.components.auth.web.ws.client.AuthServiceClient;
import com.gisinfo.sand.core.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;


@Configurable
public class AuthConfigurable {

    @Autowired
    private AuthProperties authProperties;

    @Bean
    AuthServiceClient authServiceClient(){
        return new AuthServiceClient(authProperties.getUrl());
    }

    @Bean
    @ConditionalOnMissingBean(IUserService.class)
    public IUserService authUserService() {
        AuthUserService authUserService= new AuthUserService();
        authUserService.setAuthServiceClient(authServiceClient());
        return authUserService;
    }

    public AuthProperties getAuthProperties() {
        return authProperties;
    }

    public void setAuthProperties(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }
}
