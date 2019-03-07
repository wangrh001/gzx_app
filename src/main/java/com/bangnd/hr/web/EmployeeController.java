package com.bangnd.hr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.hr.web.*;
import com.bangnd.hr.entity.*;
import com.bangnd.hr.form.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.service.impl.*;
import com.bangnd.hr.vo.*;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    EmployeeCityService employeeCityService;
    @Resource
    EmployeeDeptService employeeDeptService;
    @Resource
    EmployeeManageGradeService employeeManageGradeService;
    @Resource
    EmployeeTechGradeService employeeTechGradeService;
    @Resource
    EmployeePositionService employeePositionService;

    @RequestMapping("/hr/employee")
    public String home(Model model, EmployeeSearchForm employeeSearchForm) {
        List<Employee> employees = employeeService.getEmployeeList(employeeSearchForm);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", employeeDeptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", employeePositionService.getAll());
        List<EmployeeVO> employeeVOs = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                EmployeeVO employeeVO = new EmployeeVO();
                employeeVO.setId(employee.getId());
                employeeVO.setName(employee.getName());
                employeeVO.setDeptName((employeeDeptService.getEmployeeDeptById(employee.getDept())).getName());
                employeeVO.setTechGradeName((employeeTechGradeService.getEmployeeTechGradeById(employee.getTechGrade())).getName());
                employeeVOs.add(employeeVO);
            }
        }
        model.addAttribute("employeeVOs", employeeVOs);
        return "/hr/employeeList";
    }

    @RequestMapping("/hr/employee/toAdd")
    public String toAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", employeeDeptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", employeePositionService.getAll());
        return "/hr/employeeAdd";
    }

    @RequestMapping("/hr/employee/add")
    public String add(Employee employee) {
        employee.setState(ConstantCfg.ORDER_STATE_INITIAL);
        employee.setCreator(0);
        employee.setCreateTime(new Date());
        employeeService.save(employee);
        return "redirect:/hr/employee";
    }

    @RequestMapping("/hr/employee/toModify")
    public String toModify(Model model, Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("citys", employeeCityService.getAll());
        model.addAttribute("depts", employeeDeptService.getAll());
        model.addAttribute("manageGrades", employeeManageGradeService.getAll());
        model.addAttribute("techGrades", employeeTechGradeService.getAll());
        model.addAttribute("positions", employeePositionService.getAll());
        return "/hr/employeeAdd";
    }

    @RequestMapping("/hr/employee/modify")
    public String modify(Employee employee, Long id) {
        Employee oldEmployee = employeeService.getEmployeeById(id);
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