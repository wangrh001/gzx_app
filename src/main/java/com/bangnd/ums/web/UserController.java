package com.bangnd.ums.web;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.User;
import com.bangnd.ums.form.UserSearchForm;
import com.bangnd.ums.service.UserService;
import com.bangnd.ums.vo.UserVO;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.security.MD5Util;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private AgentService agentService;

    @RequestMapping("/ums/user")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, UserSearchForm userSearchForm) {
        List<UserVO> userVOs = new ArrayList<>();
        //为空才可能需要分页
        if(userSearchForm.getAgentName()==null&&userSearchForm.getEmployeeName()==null&&userSearchForm.getUserName()==null){
            Page<User> pages = userService.getUserList(Integer.valueOf(pageNum==null?"1":pageNum),
                                                        ConstantCfg.NUM_PER_PAGE,userSearchForm);
            if (pages != null) {
                for (User user : pages) {
                    transferUserToUserVO(userVOs, user);
                }
            }
            int pagenum=Integer.valueOf(pageNum==null?"1":pageNum);
            model.addAttribute("page",pages);
            model.addAttribute("pageNum",pagenum);
            model.addAttribute("totalPages",pages.getTotalPages());
            System.out.println("totalPages="+pages.getTotalPages());
            model.addAttribute("totalElements",pages.getTotalElements());
        }else{
            if(userSearchForm.getUserName()!=null&&!"".equals(userSearchForm.getUserName())){
                List<User> users = userService.getAllUserByUserName(userSearchForm.getUserName());
                if(users!=null){
                    for(User user:users){
                        transferUserToUserVO(userVOs, user);
                    }
                }
            }
            if(userSearchForm.getEmployeeName()!=null&&!"".equals(userSearchForm.getEmployeeName())){
                List<Employee> employees = employeeService.getEmployeeByEmployeeName(userSearchForm.getEmployeeName());
                if(employees!=null){
                    for(Employee employee:employees){
                        User user = userService.getUserById(employee.getUserId());
                        userVOs.add(transUserToUserVo(user,employee.getName(),""));
                    }
                }
            }
            if(userSearchForm.getAgentName()!=null&&!"".equals(userSearchForm.getAgentName())){
                List<Agent> agents = agentService.getAgentByAgentName(userSearchForm.getAgentName());
                if(agents!=null){
                    for(Agent agent:agents){
                        User user = userService.getUserById(agent.getUserId());
                        userVOs.add(transUserToUserVo(user,"",agent.getName()));
                    }
                }
            }
        }
        model.addAttribute("userVOs", userVOs);
        return "/ums/userList";
    }

    private void transferUserToUserVO(List<UserVO> userVOs, User user) {
        Employee employee;
        Agent agent;
        if(user!=null) {
            employee = employeeService.getEmployeeByUserId(user.getId());
            agent = agentService.getAgentByUserId(user.getId());
            if (employee != null) {
                userVOs.add(transUserToUserVo(user,employee.getName(),""));
            }else if(agent!=null){
                userVOs.add(transUserToUserVo(user,"",agent.getName()));
            }
        }
    }

    private UserVO transUserToUserVo(User user,String employeeName,String agentName){
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUserName(user.getUserName());
        if(user.getState()==ConstantCfg.STATE_1){
            userVO.setUserStateName(ConstantCfg.STATE_1_NAME);
        }else if(user.getState()==ConstantCfg.STATE_100) {
            userVO.setUserStateName(ConstantCfg.STATE_100_NAME);
        }
        userVO.setEmployeeName(employeeName);
        userVO.setAgentName(agentName);
        userVO.setLastLogInTime(user.getLastLogInTime());
        return userVO;
    }

    @RequestMapping("/ums/user/toAdd")
    public String toAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("agents", agentService.getOutAllAgents());
        return "/ums/userAdd";
    }

    @RequestMapping("/ums/user/add")
    public String add(User user, long agentId, long employeeId) {
        user.setState(ConstantCfg.ORDER_STATE_INITIAL);
        user.setPassword(MD5Util.getMD5(user.getPassword(), true, 32));
        user.setCreator(0);
        user.setCreateTime(new Date());
        userService.save(user);
        if (agentId != 0) {
            agentService.bandUser(agentId, user.getId(),user.getUserName());
        }
        if (employeeId != 0) {
            Agent agent = agentService.getAgentByEmployeeId(employeeId);
            if(agent!=null){
                agentService.bandUser(agent.getId(),user.getId(),user.getUserName());
            }
            employeeService.bandUser(employeeId, user.getId(),user.getUserName());
        }
        return "redirect:/ums/user";
    }

    @RequestMapping("/ums/user/toModify")
    public String toModify(Model model, Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("employeeId", employeeService.getEmployeeByUserId(user.getId()));
        model.addAttribute("agentId", agentService.getAgentByUserId(user.getId()));
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("agents", agentService.getOutAllAgents());
        return "/ums/userEdit";
    }

    @RequestMapping("/ums/user/modify")
    public String modify(User user, Long id,Long employeeId,Long agentId) {
        User oldUser = userService.getUserById(id);
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(MD5Util.getMD5(user.getPassword(), true, 32));
        oldUser.setUpdator(0);
        oldUser.setUpdateTime(new Date());
        if(employeeId!=0){
            employeeService.bandUser(employeeId,id,user.getUserName());
        }else if(agentId!=0){
            agentService.bandUser(agentId,id,user.getUserName());
        }
        userService.merge(oldUser);
        return "redirect:/ums/user/toModify?id=" + id;
    }

    @RequestMapping("/ums/user/delete")
    public String delete(Long id) {
        User oldUser = userService.getUserById(id);
        oldUser.setState(100);
        oldUser.setUpdator(0);
        oldUser.setUpdateTime(new Date());
        userService.merge(oldUser);
        return "redirect:/ums/user";
    }

    @RequestMapping("/ums/toChangePsd")
    public String toChangePsd() {
        System.out.println("enter the toChange method");
        return "/ums/password";
    }

    @RequestMapping("/ums/changePsd")
    public String changePsd(String userName, String password, String newPassword1) {
        boolean flag = userService.verifyPassword(userName, password);
        if (flag) {
            userService.changePsd(userName, newPassword1);
        } else {
            return "/ums/password";
        }
        return "redirect:/index";
    }
}