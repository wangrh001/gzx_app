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
public class CommissionController {
    @Resource
    private CommissionService commissionService;
    @Resource
    CommissionBusinessTypeService commissionBusinessTypeService;
    @Resource
    CommissionProductTypeService commissionProductTypeService;
    @Resource
    CommissionLevelService commissionLevelService;
    @Resource
    CommissionTypeService commissionTypeService;
    @Resource
    CommissionWayService commissionWayService;
    @Resource
    CommissionBaseTypeService commissionBaseTypeService;
    @Resource
    CommissionChannelTypeService commissionChannelTypeService;

    @RequestMapping("/sales/commission")
    public String home(Model model, CommissionSearchForm commissionSearchForm) {
        List<Commission> commissions = commissionService.getCommissionList(commissionSearchForm);
        model.addAttribute("businessTypes", commissionBusinessTypeService.getAll());
        model.addAttribute("productTypes", commissionProductTypeService.getAll());
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", commissionTypeService.getAll());
        model.addAttribute("ways", commissionWayService.getAll());
        model.addAttribute("baseTypes", commissionBaseTypeService.getAll());
        model.addAttribute("channelTypes", commissionChannelTypeService.getAll());
        List<CommissionVO> commissionVOs = new ArrayList<>();
        if (commissions != null) {
            for (Commission commission : commissions) {
                CommissionVO commissionVO = new CommissionVO();
                commissionVO.setId(commission.getId());
                commissionVO.setBusinessTypeName((commissionBusinessTypeService.getCommissionBusinessTypeById(commission.getBusinessType())).getName());
                commissionVO.setProductTypeName((commissionProductTypeService.getCommissionProductTypeById(commission.getProductType())).getName());
                commissionVO.setProductId(commission.getProductId());
                commissionVOs.add(commissionVO);
            }
        }
        model.addAttribute("commissionVOs", commissionVOs);
        return "/sales/commissionList";
    }

    @RequestMapping("/sales/commission/toAdd")
    public String toAdd(Model model) {
        Commission commission = new Commission();
        model.addAttribute("commission", commission);
        model.addAttribute("businessTypes", commissionBusinessTypeService.getAll());
        model.addAttribute("productTypes", commissionProductTypeService.getAll());
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", commissionTypeService.getAll());
        model.addAttribute("ways", commissionWayService.getAll());
        model.addAttribute("baseTypes", commissionBaseTypeService.getAll());
        model.addAttribute("channelTypes", commissionChannelTypeService.getAll());
        return "/sales/commissionAdd";
    }

    @RequestMapping("/sales/commission/add")
    public String add(Commission commission) {
        commission.setState(ConstantCfg.ORDER_STATE_INITIAL);
        commission.setCreator(0);
        commission.setCreateTime(new Date());
        commissionService.save(commission);
        return "redirect:/sales/commission";
    }

    @RequestMapping("/sales/commission/toModify")
    public String toModify(Model model, Long id) {
        Commission commission = commissionService.getCommissionById(id);
        model.addAttribute("commission", commission);
        model.addAttribute("businessTypes", commissionBusinessTypeService.getAll());
        model.addAttribute("productTypes", commissionProductTypeService.getAll());
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", commissionTypeService.getAll());
        model.addAttribute("ways", commissionWayService.getAll());
        model.addAttribute("baseTypes", commissionBaseTypeService.getAll());
        model.addAttribute("channelTypes", commissionChannelTypeService.getAll());
        return "/sales/commissionAdd";
    }

    @RequestMapping("/sales/commission/modify")
    public String modify(Commission commission, Long id) {
        Commission oldCommission = commissionService.getCommissionById(id);
        oldCommission.setBusinessType(commission.getBusinessType());
        oldCommission.setProductType(commission.getProductType());
        oldCommission.setProductId(commission.getProductId());
        oldCommission.setLevel(commission.getLevel());
        oldCommission.setType(commission.getType());
        oldCommission.setWay(commission.getWay());
        oldCommission.setPercent(commission.getPercent());
        oldCommission.setSum(commission.getSum());
        oldCommission.setBaseType(commission.getBaseType());
        oldCommission.setChannelType(commission.getChannelType());
        oldCommission.setStartDate(commission.getStartDate());
        oldCommission.setEndDate(commission.getEndDate());
        oldCommission.setUpdator(0);
        oldCommission.setUpdateTime(new Date());
        commissionService.merge(oldCommission);
        return "redirect:/sales/commission/toModify?id=" + id;
    }

    @RequestMapping("/sales/commission/delete")
    public String delete(Long id) {
        Commission oldCommission = commissionService.getCommissionById(id);
        oldCommission.setState(100);
        oldCommission.setUpdator(0);
        oldCommission.setUpdateTime(new Date());
        commissionService.merge(oldCommission);
        return "redirect:/sales/commission";
    }
}