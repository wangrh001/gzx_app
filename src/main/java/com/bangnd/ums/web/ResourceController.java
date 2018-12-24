package com.bangnd.ums.web;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ResourceController {

    @Resource
    ResourceService resourceService;

    //获取该用户可以访问的菜单
    @RequestMapping("/index")
    public String getMenuTree(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        String menuTree=resourceService.getMenuTreeString(user.getId());
        model.addAttribute("menus",menuTree);
        return "/index";
    }
}
