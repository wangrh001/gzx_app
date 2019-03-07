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
public class SalaryController {
    @Resource
    private SalaryService salaryService;
    @Resource
    SalaryExtendStateService salaryExtendStateService;

    @RequestMapping("/hr/salary")
    public String home(Model model, SalarySearchForm salarySearchForm) {
        List<Salary> salarys = salaryService.getSalaryList(salarySearchForm);
        model.addAttribute("extendStates", salaryExtendStateService.getAll());
        List<SalaryVO> salaryVOs = new ArrayList<>();
        if (salarys != null) {
            for (Salary salary : salarys) {
                SalaryVO salaryVO = new SalaryVO();
                salaryVO.setId(salary.getId());
                salaryVO.setEmpName(salary.getEmpName());
                salaryVO.setBasicSalary(salary.getBasicSalary());
                salaryVO.setCurrentSalary(salary.getCurrentSalary());
                salaryVO.setExtendStateName((salaryExtendStateService.getSalaryExtendStateById(salary.getExtendState())).getName());
                salaryVOs.add(salaryVO);
            }
        }
        model.addAttribute("salaryVOs", salaryVOs);
        return "/hr/salaryList";
    }

    @RequestMapping("/hr/salary/toAdd")
    public String toAdd(Model model) {
        Salary salary = new Salary();
        model.addAttribute("salary", salary);
        model.addAttribute("extendStates", salaryExtendStateService.getAll());
        return "/hr/salaryAdd";
    }

    @RequestMapping("/hr/salary/add")
    public String add(Salary salary) {
        salary.setState(ConstantCfg.ORDER_STATE_INITIAL);
        salary.setCreator(0);
        salary.setCreateTime(new Date());
        salaryService.save(salary);
        return "redirect:/hr/salary";
    }

    @RequestMapping("/hr/salary/toModify")
    public String toModify(Model model, Long id) {
        Salary salary = salaryService.getSalaryById(id);
        model.addAttribute("salary", salary);
        model.addAttribute("extendStates", salaryExtendStateService.getAll());
        return "/hr/salaryAdd";
    }

    @RequestMapping("/hr/salary/modify")
    public String modify(Salary salary, Long id) {
        Salary oldSalary = salaryService.getSalaryById(id);
        oldSalary.setEmpName(salary.getEmpName());
        oldSalary.setMonth(salary.getMonth());
        oldSalary.setBasicSalary(salary.getBasicSalary());
        oldSalary.setCurrentSalary(salary.getCurrentSalary());
        oldSalary.setExtendState(salary.getExtendState());
        oldSalary.setExtendDate(salary.getExtendDate());
        oldSalary.setUpdator(0);
        oldSalary.setUpdateTime(new Date());
        salaryService.merge(oldSalary);
        return "redirect:/hr/salary/toModify?id=" + id;
    }

    @RequestMapping("/hr/salary/delete")
    public String delete(Long id) {
        Salary oldSalary = salaryService.getSalaryById(id);
        oldSalary.setState(100);
        oldSalary.setUpdator(0);
        oldSalary.setUpdateTime(new Date());
        salaryService.merge(oldSalary);
        return "redirect:/hr/salary";
    }
}