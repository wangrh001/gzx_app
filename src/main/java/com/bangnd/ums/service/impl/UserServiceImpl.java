package com.bangnd.ums.service.impl;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.repository.UserRepository;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.security.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    //验证用户名是否存在
    @Override
    public boolean verifyUserName(String userName) {
        User user1 = userRepository.findUserByUserName(userName);
        boolean flag = false;
        if (user1 != null) {
            flag = true;
        }
        return flag;
    }

    //验证密码是否正确
    @Override
    public boolean verifyPassword(String userName, String password) {
        User user1 = userRepository.findUserByUserName(userName);
        boolean flag = false;
        if (user1 != null) {
            if (user1.getPassword().equals(MD5Util.getMD5(password, true, 32))) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void changePsd(String userName, String password) {
        System.out.println("userName=" + userName + ":password:" + password);
        User user = userRepository.findUserByUserName(userName);
        user.setPassword(MD5Util.getMD5(password, true, 32));
        user.setUpdator(user.getId());
        user.setUpdateTime(new Date());
        userRepository.save(user);
    }
}
