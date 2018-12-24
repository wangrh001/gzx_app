package com.bangnd.ums.web;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.service.UserService;
import com.bangnd.ums.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import javax.annotation.Resource;


@Controller
public class LoginController {

    @Resource
    UserService userService;

    @Resource
    ResourceService resourceService;

    //跳转到登录页
    @RequestMapping("/login")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/ums/login";
    }

    //验证登录
    @RequestMapping("/loginVerify")
    public String loginVerify(Model model,String userName,String password,HttpSession session){
        boolean verifyUserName = userService.verifyUserName(userName);
        User user = userService.getUserByUserName(userName);
        if(!verifyUserName){
            model.addAttribute("message","用户不存在，请确定输入是否正确");
            return "redirect:/login";
        }
        boolean verifyPassword = userService.verifyPassword(userName,password);
        if (!verifyPassword) {
            model.addAttribute("message","密码错误，请重新输入");
            return "redirect:/login";
        }
        session.setAttribute("user", user);
        return "redirect:/index";
    }

    //获取该用户可以访问的菜单
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
