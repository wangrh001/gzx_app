package com.bangnd.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.sales.web.*;
import com.bangnd.sales.entity.*;
import com.bangnd.sales.form.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.service.impl.*;
import com.bangnd.sales.vo.*;

@Controller
public class PerformanceCommissionController {
    @Resource
    private PerformanceCommissionService performanceCommissionService;
    @Resource
    PerformanceCommissionProcessService performanceCommissionProcessService;

    @RequestMapping("/sales/performanceCommission")
    public String home(Model model, PerformanceCommissionSearchForm performanceCommissionSearchForm) {
        List<PerformanceCommission> performanceCommissions = performanceCommissionService.getPerformanceCommissionList(performanceCommissionSearchForm);
        model.addAttribute("processs", performanceCommissionProcessService.getAll());
        List<PerformanceCommissionVO> performanceCommissionVOs = new ArrayList<>();
        if (performanceCommissions != null) {
            for (PerformanceCommission performanceCommission : performanceCommissions) {
                PerformanceCommissionVO performanceCommissionVO = new PerformanceCommissionVO();
                performanceCommissionVO.setId(performanceCommission.getId());
                performanceCommissionVO.setAgentId(performanceCommission.getAgentId());
                performanceCommissionVO.setMonth(performanceCommission.getMonth());
                performanceCommissionVO.setAgentName(performanceCommission.getAgentName());
                performanceCommissionVO.setCommission(performanceCommission.getCommission());
                performanceCommissionVO.setPerformance(performanceCommission.getPerformance());
                performanceCommissionVO.setProcessName((performanceCommissionProcessService.getPerformanceCommissionProcessById(performanceCommission.getProcess())).getName());
                performanceCommissionVOs.add(performanceCommissionVO);
            }
        }
        model.addAttribute("performanceCommissionVOs", performanceCommissionVOs);
        return "/sales/performanceCommissionList";
    }

    @RequestMapping("/sales/performanceCommission/toAdd")
    public String toAdd(Model model) {
        PerformanceCommission performanceCommission = new PerformanceCommission();
        model.addAttribute("performanceCommission", performanceCommission);
        model.addAttribute("processs", performanceCommissionProcessService.getAll());
        return "/sales/performanceCommissionAdd";
    }

    @RequestMapping("/sales/performanceCommission/add")
    public String add(PerformanceCommission performanceCommission) {
        performanceCommission.setState(ConstantCfg.ORDER_STATE_INITIAL);
        performanceCommission.setCreator(0);
        performanceCommission.setCreateTime(new Date());
        performanceCommissionService.save(performanceCommission);
        return "redirect:/sales/performanceCommission";
    }

    @RequestMapping("/sales/performanceCommission/toModify")
    public String toModify(Model model, Long id) {
        PerformanceCommission performanceCommission = performanceCommissionService.getPerformanceCommissionById(id);
        model.addAttribute("performanceCommission", performanceCommission);
        model.addAttribute("processs", performanceCommissionProcessService.getAll());
        return "/sales/performanceCommissionAdd";
    }

    @RequestMapping("/sales/performanceCommission/modify")
    public String modify(PerformanceCommission performanceCommission, Long id) {
        PerformanceCommission oldPerformanceCommission = performanceCommissionService.getPerformanceCommissionById(id);
        oldPerformanceCommission.setAgentId(performanceCommission.getAgentId());
        oldPerformanceCommission.setAgentName(performanceCommission.getAgentName());
        oldPerformanceCommission.setCommission(performanceCommission.getCommission());
        oldPerformanceCommission.setPerformance(performanceCommission.getPerformance());
        oldPerformanceCommission.setProcess(performanceCommission.getProcess());
        oldPerformanceCommission.setUpdator(0);
        oldPerformanceCommission.setUpdateTime(new Date());
        performanceCommissionService.merge(oldPerformanceCommission);
        return "redirect:/sales/performanceCommission/toModify?id=" + id;
    }

    @RequestMapping("/sales/performanceCommission/delete")
    public String delete(Long id) {
        PerformanceCommission oldPerformanceCommission = performanceCommissionService.getPerformanceCommissionById(id);
        oldPerformanceCommission.setState(100);
        oldPerformanceCommission.setUpdator(0);
        oldPerformanceCommission.setUpdateTime(new Date());
        performanceCommissionService.merge(oldPerformanceCommission);
        return "redirect:/sales/performanceCommission";
    }
}