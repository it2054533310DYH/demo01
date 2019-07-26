package com.czxy.interceptor;


import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 11:05
 * @Description:
 */
@Component
public class TypeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //返回除去host（域名或者ip）部分的路径
        String url = request.getRequestURI();
        System.out.println(url);

        //如果路径执行了删除,需要对用户是否登录做一个校验
        if ( url.contains("delete")){

            User user = (User) request.getSession().getAttribute("user");
            if (user==null){
                return false;
            }else{
                return true;
            }

        }

        //其余方法直接放行
        return true;
    }
}