package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:26
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserServlet {


    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Void> checkLogin(HttpServletRequest request,User user){

        System.out.println("需要校验登录的对象是:"+user);
        User login = userService.getLogin(user);

        System.out.println("查找到的对象:"+login);
        if (login==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        //把对象存放在session域中
        request.getSession().setAttribute("user",login);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}