package com.bangnd.cs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.cs.web.*;
import com.bangnd.cs.entity.*;
import com.bangnd.cs.form.*;
import com.bangnd.cs.service.*;
import com.bangnd.cs.service.impl.*;
import com.bangnd.cs.vo.*;

@Controller
public class WorkOrderController {
    @Resource
    private WorkOrderService workOrderService;
    @Resource
    WorkOrderCstypeService workOrderCstypeService;
    @Resource
    WorkOrderCsStateService workOrderCsStateService;

    @RequestMapping("/cs/workOrder")
    public String home(Model model, WorkOrderSearchForm workOrderSearchForm) {
        List<WorkOrder> workOrders = workOrderService.getWorkOrderList(workOrderSearchForm);
        model.addAttribute("cstypes", workOrderCstypeService.getAll());
        model.addAttribute("csStates", workOrderCsStateService.getAll());
        List<WorkOrderVO> workOrderVOs = new ArrayList<>();
        if (workOrders != null) {
            for (WorkOrder workOrder : workOrders) {
                WorkOrderVO workOrderVO = new WorkOrderVO();
                workOrderVO.setId(workOrder.getId());
                workOrderVO.setCsName(workOrder.getCsName());
                workOrderVO.setCstypeName((workOrderCstypeService.getWorkOrderCstypeById(workOrder.getCstype())).getName());
                workOrderVO.setOrderId(workOrder.getOrderId());
                workOrderVO.setCustomerName(workOrder.getCustomerName());
                workOrderVO.setCsStateName((workOrderCsStateService.getWorkOrderCsStateById(workOrder.getCsState())).getName());
                workOrderVOs.add(workOrderVO);
            }
        }
        model.addAttribute("workOrderVOs", workOrderVOs);
        return "/cs/workOrderList";
    }

    @RequestMapping("/cs/workOrder/toAdd")
    public String toAdd(Model model) {
        WorkOrder workOrder = new WorkOrder();
        model.addAttribute("workOrder", workOrder);
        model.addAttribute("cstypes", workOrderCstypeService.getAll());
        model.addAttribute("csStates", workOrderCsStateService.getAll());
        return "/cs/workOrderAdd";
    }

    @RequestMapping("/cs/workOrder/add")
    public String add(WorkOrder workOrder) {
        workOrder.setState(ConstantCfg.ORDER_STATE_INITIAL);
        workOrder.setCreator(0);
        workOrder.setCreateTime(new Date());
        workOrderService.save(workOrder);
        return "redirect:/cs/workOrder";
    }

    @RequestMapping("/cs/workOrder/toModify")
    public String toModify(Model model, Long id) {
        WorkOrder workOrder = workOrderService.getWorkOrderById(id);
        model.addAttribute("workOrder", workOrder);
        model.addAttribute("cstypes", workOrderCstypeService.getAll());
        model.addAttribute("csStates", workOrderCsStateService.getAll());
        return "/cs/workOrderAdd";
    }

    @RequestMapping("/cs/workOrder/modify")
    public String modify(WorkOrder workOrder, Long id) {
        WorkOrder oldWorkOrder = workOrderService.getWorkOrderById(id);
        oldWorkOrder.setCsName(workOrder.getCsName());
        oldWorkOrder.setCstype(workOrder.getCstype());
        oldWorkOrder.setCsDesc(workOrder.getCsDesc());
        oldWorkOrder.setCustomerName(workOrder.getCustomerName());
        oldWorkOrder.setCsState(workOrder.getCsState());
        oldWorkOrder.setUpdator(0);
        oldWorkOrder.setUpdateTime(new Date());
        workOrderService.merge(oldWorkOrder);
        return "redirect:/cs/workOrder/toModify?id=" + id;
    }

    @RequestMapping("/cs/workOrder/delete")
    public String delete(Long id) {
        WorkOrder oldWorkOrder = workOrderService.getWorkOrderById(id);
        oldWorkOrder.setState(100);
        oldWorkOrder.setUpdator(0);
        oldWorkOrder.setUpdateTime(new Date());
        workOrderService.merge(oldWorkOrder);
        return "redirect:/cs/workOrder";
    }
}