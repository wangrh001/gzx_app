package com.bangnd.sales.web;

import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;
import com.bangnd.sales.service.PerformanceCommissionProcessService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.sales.vo.PerformanceCommissionVO;
import com.bangnd.util.cfg.ConstantCfg;
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
public class PerformanceCommissionController {
    @Resource
    private PerformanceCommissionService performanceCommissionService;
    @Resource
    PerformanceCommissionProcessService performanceCommissionProcessService;

    @RequestMapping("/sales/performanceCommission")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, PerformanceCommissionSearchForm performanceCommissionSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<PerformanceCommission> pages = performanceCommissionService.getPerformanceCommissionList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,performanceCommissionSearchForm);
        model.addAttribute("processs", performanceCommissionProcessService.getAll());
        List<PerformanceCommissionVO> performanceCommissionVOs = new ArrayList<>();
        if (pages != null) {
            for (PerformanceCommission performanceCommission : pages) {
                PerformanceCommissionVO performanceCommissionVO = new PerformanceCommissionVO();
                performanceCommissionVO.setId(performanceCommission.getId());
                performanceCommissionVO.setMonth(performanceCommission.getMonth());
                performanceCommissionVO.setAgentName(performanceCommission.getAgentName());
                performanceCommissionVO.setEmployeeName(performanceCommission.getEmployeeName());
                performanceCommissionVO.setOrderProdId(performanceCommission.getOrderProdId());
                performanceCommissionVO.setCommission(performanceCommission.getCommission());
                performanceCommissionVO.setPerformance(performanceCommission.getPerformance());
                performanceCommissionVO.setProcessName((performanceCommissionProcessService.getPerformanceCommissionProcessById(performanceCommission.getProcess())).getName());
                performanceCommissionVOs.add(performanceCommissionVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
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