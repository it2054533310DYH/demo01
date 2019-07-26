package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/7 00:24
 * @Description:
 */
@Component
@Transactional
public class UserServicelmpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getLogin(User user) {

        List<User> list = userMapper.selectAll();
        System.out.println(list);
        for (User user1 : list) {
            if (user1.getUserName().equals(user.getUserName())&&user1.getPassword().equals(user.getPassword())){
                return user1;
            }
        }
        return null;
    }
}