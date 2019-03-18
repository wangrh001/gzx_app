package com.bangnd.ums.web;

import com.bangnd.ums.entity.RoleResource;
import com.bangnd.ums.entity.User;
import com.bangnd.ums.entity.UserRole;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.RoleResourceService;
import com.bangnd.ums.service.UserRoleService;
import com.bangnd.ums.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

    @Resource
    UserService userService;

    @Resource
    ResourceService resourceService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    RoleResourceService roleResourceService;

    //跳转到登录页
    @RequestMapping("/login")
    public String toLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/ums/login";
    }

    //验证登录
    @RequestMapping("/loginVerify")
    public String loginVerify(Model model, String userName, String password, HttpSession session) {
        boolean verifyUserName = userService.verifyUserName(userName);
        User user = userService.getUserByUserName(userName);
        List<UserRole> userRoles = userRoleService.findAllByUserId(user.getId());
        List<com.bangnd.ums.entity.Resource> resources=new ArrayList();
        if(userRoles!=null){
            for(UserRole userRole:userRoles){
                List<RoleResource> roleResources =roleResourceService.getRoleResourceByRoleId(userRole.getRoleId());
                if(roleResources!=null){
                    for(RoleResource roleResource:roleResources ){
                        com.bangnd.ums.entity.Resource resource = resourceService.getResourceById(roleResource.getResId());
                        resources.add(resource);
                    }
                }
            }
        }
        if (!verifyUserName) {
            model.addAttribute("message", "用户不存在，请确定输入是否正确");
            return "redirect:/login";
        }
        boolean verifyPassword = userService.verifyPassword(userName, password);
        if (!verifyPassword) {
            model.addAttribute("message", "密码错误，请重新输入");
            return "redirect:/login";
        }
        session.setAttribute("user", user);
        System.out.println("resources.size()="+resources.size());
        session.setAttribute("userRes",resources);
        return "redirect:/index";
    }

    //获取该用户可以访问的菜单
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
