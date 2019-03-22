package com.example.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        /**
         * 图片资源路径映射
         * @param registry
         */
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/D:/attached/image/");
    }
}
