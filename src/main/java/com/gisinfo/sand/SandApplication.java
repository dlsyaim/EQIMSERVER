package com.gisinfo.sand;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootApplication
@ServletComponentScan("com.gisinfo.sand")
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@EnableAsync
@EnableCaching
@EnableSwagger2
public class SandApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication application=new SpringApplication(SandApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.application().setBannerMode(Banner.Mode.OFF);
        return application.sources(SandApplication.class);
    }
}