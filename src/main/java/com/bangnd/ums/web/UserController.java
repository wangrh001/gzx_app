package com.bangnd.ums.web;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/toChangePsd")
    public String toChangePsd() {
        System.out.println("enter the toChange method");
        return "/ums/password";
    }

    @RequestMapping("/changePsd")
    public String changePsd(String userName, String password, String newPassword1) {
        boolean flag = userService.verifyPassword(userName, password);
        if (flag) {
            userService.changePsd(userName, newPassword1);
        } else {
            return "/ums/password";
        }
        return "/index";
    }

}
