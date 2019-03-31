package com.bangnd.ums.web;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.RoleResource;
import com.bangnd.ums.entity.User;
import com.bangnd.ums.entity.UserRole;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.RoleResourceService;
import com.bangnd.ums.service.UserRoleService;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.cfg.ConstantCfg;
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
    @Resource
    EmployeeService employeeService;
    @Resource
    AgentService agentService;

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
        if (!verifyUserName) {
            model.addAttribute("message", "用户不存在，请确定输入是否正确");
            return "redirect:/login";
        }
        boolean verifyPassword = userService.verifyPassword(userName, password);
        if (!verifyPassword) {
            model.addAttribute("message", "密码错误，请重新输入");
            return "redirect:/login";
        }
        User user = userService.getUserByUserName(userName);
        putUserToSession(session,user);
        putResToSession(session,user);
        putPositionToSession(session,user);

        return "redirect:/index";
    }
    private void putUserToSession(HttpSession session,User user){
        session.setAttribute("user", user);
    }

    //获取该用户可以访问的菜单
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

    private void putResToSession(HttpSession session,User user){
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
        session.setAttribute("userRes",resources);
    }

    private void putPositionToSession(HttpSession session,User user){
        Employee employee=employeeService.getEmployeeByUserId(user.getId());
        int positionId = 0;
        if(employee!=null){
            positionId=employee.getPosition();
        }else {
            Agent agent = agentService.getAgentByUserId(user.getId());
            if(agent!=null){
                positionId=ConstantCfg.POSITION_SALES_11;
            }
        }
        session.setAttribute("positionId",positionId);
    }
}
