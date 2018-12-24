package com.bangnd.hr.web;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

public class EmployeeController {
    @Resource
    EmployeeService employeeService;
//
//
    @RequestMapping("/hr")
    public String index() {
        return "redirect:/employee/list";
    }

    @RequestMapping("/hr/list")
    public String list(Model model) {
        List<Employee> employees=employeeService.getEmployeeList();
        model.addAttribute("employees", employees);
        return "hr/list";
    }

    @RequestMapping("/hr/toAdd")
    public String toAdd() {
        return "hr/EmployeeAdd";
    }

    @RequestMapping("/hr/add")
    public String add(Employee employee) {
        employeeService.save(employee);
        return "redirect:/hr/list";
    }

    @RequestMapping("/hr/toEdit")
    public String toEdit(Model model,Long id) {
        Employee employees=employeeService.findEmployeeById(id);
        model.addAttribute("employees", employees);
        return "hr/EmployeeEdit";
    }

    @RequestMapping("/hr/edit")
    public String edit(Employee employees) {
        employeeService.edit(employees);
        return "redirect:/hr/list";
    }


    @RequestMapping("/hr/delete")
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/hr/list";
    }
}
