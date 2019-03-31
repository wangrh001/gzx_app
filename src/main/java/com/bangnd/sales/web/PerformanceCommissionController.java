package com.bangnd.sales.web;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.sales.service.PerformanceCommissionProcessService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.sales.vo.PerformanceCommDetailVO;
import com.bangnd.sales.vo.PerformanceCommissionVO;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.date.DateUtil;
import org.hibernate.validator.constraints.Email;
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
    @Resource
    PerformanceCommDetailService performanceCommDetailService;
    @Resource
    OrderService orderService;
    @Resource
    AgentService agentService;
    @Resource
    EmployeeService employeeService;

    @RequestMapping("/sales/performanceCommission")
    public String home(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, PerformanceCommissionSearchForm performanceCommissionSearchForm) {
        if (pageNum == null) {
            pageNum = "1";
        }
        Page<PerformanceCommission> pages = performanceCommissionService.getPerformanceCommissionList(Integer.valueOf(pageNum), ConstantCfg.NUM_PER_PAGE, performanceCommissionSearchForm);
        model.addAttribute("processs", performanceCommissionProcessService.getAll());
        List<PerformanceCommissionVO> performanceCommissionVOs = new ArrayList<>();
        if (pages != null) {
            for (PerformanceCommission performanceCommission : pages) {
                PerformanceCommissionVO performanceCommissionVO = new PerformanceCommissionVO();
                performanceCommissionVO.setId(performanceCommission.getId());
                performanceCommissionVO.setMonth(performanceCommission.getMonth());
                performanceCommissionVO.setSalerName(performanceCommission.getSalerName());
                performanceCommissionVO.setCommission(performanceCommission.getCommission());
                performanceCommissionVO.setMinCommission(performanceCommission.getMinCommission());
                performanceCommissionVO.setMaxCommission(performanceCommission.getMaxCommission());
                performanceCommissionVO.setInterest(performanceCommission.getInterest());
                performanceCommissionVO.setPerformance(performanceCommission.getPerformance());
                performanceCommissionVO.setProcessName((performanceCommissionProcessService.getPerformanceCommissionProcessById(performanceCommission.getProcess())).getName());
                performanceCommissionVOs.add(performanceCommissionVO);
            }
        }

        int pagenum = Integer.valueOf(pageNum);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", pagenum);
        model.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages=" + pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
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

    @RequestMapping("/sales/performanceCommission/detailList")
    public String toModify(Model model, Long id) {
        List<PerformanceCommDetailVO> performanceCommDetailVOs = new ArrayList<>();
        PerformanceCommission performanceCommission = performanceCommissionService.getPerformanceCommissionById(id);
        if (performanceCommission != null) {
            Date startDate = DateUtil.getMonthStart(performanceCommission.getMonth());
            Date endDate = DateUtil.getMonthEnd(performanceCommission.getMonth());
            List<Order> orders = orderService.findOrderBySalesId(Long.valueOf(performanceCommission.getSalerId()).intValue(), startDate, endDate);
            if (orders != null && orders.size() > 0) {
                for (Order order : orders) {
                    PerformanceCommDetail performanceCommDetail = performanceCommDetailService.getPerformanceCommDetail(order.getId(), order.getSalerId());
                    if (performanceCommDetail != null) {
                        PerformanceCommDetailVO performanceCommDetailVO = new PerformanceCommDetailVO();
                        performanceCommDetailVO.setOrderId(performanceCommDetail.getOrderId());
                        performanceCommDetailVO.setAgentName(agentService.getAgentById(performanceCommission.getSalerId()).getName());
                        performanceCommDetailVO.setCommission(performanceCommDetail.getCommission());
                        performanceCommDetailVO.setMinCommission(performanceCommDetail.getMinCommission());
                        performanceCommDetailVO.setMaxCommission(performanceCommDetail.getMaxCommission());
                        performanceCommDetailVO.setPerformance(performanceCommDetail.getPerformance());
                        performanceCommDetailVO.setInterest(performanceCommDetail.getInterest());
                        performanceCommDetailVOs.add(performanceCommDetailVO);
                    }
                }
            }
        }
        model.addAttribute("performanceCommDetailVOs", performanceCommDetailVOs);
        return "/sales/performanceCommDetailList";
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