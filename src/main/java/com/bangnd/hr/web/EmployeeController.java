package com.bangnd.hr.web;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.form.EmployeeSearchForm;
import com.bangnd.hr.service.*;
import com.bangnd.hr.vo.EmployeeVO;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    EmployeeCityService employeeCityService;
    @Resource
    DeptService deptService;
    @Resource
    EmployeeManageGradeService employeeManageGradeService;
    @Resource
    EmployeeTechGradeService employeeTechGradeService;
    @Resource
    PositionService positionService;
    @Resource
    AgentService agentService;
    /**
     * form表单提交 Date类型数据绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/hr/employee")
    public String home(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, EmployeeSearchForm employeeSearchForm) {
        if (pageNum == null) {
            pageNum = "1";
        }
        Page<Employee> pages = employeeService.getEmployeeList(Integer.valueOf(pageNum), ConstantCfg.NUM_PER_PAGE, employeeSearchForm);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", deptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", positionService.getAll());
        List<EmployeeVO> employeeVOs = new ArrayList<>();
        if (pages != null) {
            for (Employee employee : pages) {
                EmployeeVO employeeVO = new EmployeeVO();
                employeeVO.setId(employee.getId());
                employeeVO.setName(employee.getName());
                employeeVO.setPositionName((positionService.getPositionById(employee.getPosition())).getName());
                employeeVO.setDeptName((deptService.getDeptById(employee.getDept())).getName());
                employeeVO.setTechGradeName((employeeTechGradeService.getEmployeeTechGradeById(employee.getTechGrade())).getName());
                employeeVOs.add(employeeVO);
            }
        }

        int pagenum = Integer.valueOf(pageNum);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", pagenum);
        model.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages=" + pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("employeeVOs", employeeVOs);
        return "/hr/employeeList";
    }

    @RequestMapping("/hr/employee/toAdd")
    public String toAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", deptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", positionService.getAll());
        return "/hr/employeeAdd";
    }

    @RequestMapping("/hr/employee/add")
    public String add(Employee employee) {
        employee.setState(ConstantCfg.ORDER_STATE_INITIAL);
        employee.setCreator(0);
        employee.setCreateTime(new Date());
        employeeService.save(employee);
        //如果添加的是销售岗，需要添加到t_sales_agent表中
        if(employee.getPosition()==ConstantCfg.POSITION_SALES_11){
            Agent agent = new Agent();
            agent.setUserId(employee.getUserId());
            agent.setCentiCode(employee.getCertiCode());
            agent.setChannelType(ConstantCfg.CHANNEL_TYPE_1);
            agent.setCompanyName(ConstantCfg.COMPANY_NAME);
            agent.setEmployeeId(employee.getId());
            agent.setCreateTime(new Date());
            agent.setCreator(employee.getCreator());
            agent.setCooperateBeginDate(employee.getHiredate());
            agent.setCooperateEndDate(employee.getLeavedate());
            agent.setName(employee.getName());
            agent.setState(ConstantCfg.PUBLIC_VALID_STATE);
            agent.setPhoneNO(employee.getPhone());
            agent.setBankCode(employee.getCardNo());
            agentService.save(agent);
        }
        return "redirect:/hr/employee";
    }

    @RequestMapping("/hr/employee/toModify")
    public String toModify(Model model, Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", deptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", positionService.getAll());
        return "/hr/employeeEdit";
    }

    @RequestMapping("/hr/employee/modify")
    public String modify(Employee employee, Long id) {
        Employee oldEmployee = employeeService.getEmployeeById(employee.getId());
        oldEmployee.setName(employee.getName());
        oldEmployee.setBirthday(employee.getBirthday());
        oldEmployee.setCertiCode(employee.getCertiCode());
        oldEmployee.setCity(employee.getCity());
        oldEmployee.setDept(employee.getDept());
        oldEmployee.setManageGrade(employee.getManageGrade());
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setTechGrade(employee.getTechGrade());
        oldEmployee.setHiredate(employee.getHiredate());
        oldEmployee.setLeavedate(employee.getLeavedate());
        oldEmployee.setPhone(employee.getPhone());
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setCardNo(employee.getCardNo());
        oldEmployee.setEmgName(employee.getEmgName());
        oldEmployee.setEmgPhone(employee.getEmgPhone());
        oldEmployee.setPosition(employee.getPosition());
        oldEmployee.setUpdator(0);
        oldEmployee.setUpdateTime(new Date());
        employeeService.merge(oldEmployee);
        return "redirect:/hr/employee/toModify?id=" + id;
    }

    @RequestMapping("/hr/employee/delete")
    public String delete(Long id) {
        Employee oldEmployee = employeeService.getEmployeeById(id);
        oldEmployee.setState(100);
        oldEmployee.setUpdator(0);
        oldEmployee.setUpdateTime(new Date());
        employeeService.merge(oldEmployee);
        return "redirect:/hr/employee";
    }
}