package com.gaoh.modules.config;

import com.gaoh.modules.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/19 15:37
 * @Version: 1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class Config implements WebMvcConfigurer {
    @Autowired
    private MyHandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor);
    }
}
