package com.czxy.config;


import com.czxy.interceptor.TypeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/4 16:17
 * @Description:
 */

//controller层的配置文件
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {


    @Resource
    private TypeInterceptor typeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        InterceptorRegistration typeInterceptorRegistration = registry.addInterceptor(typeInterceptor);

        //设置拦截路径
        typeInterceptorRegistration.addPathPatterns("/**");

    }


}