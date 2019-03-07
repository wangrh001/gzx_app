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
public class TelSalesController {
    @Resource
    private TelSalesService telSalesService;
    @Resource
    TelSalesResultService telSalesResultService;
    @Resource
    TelSalesTaskDelayService telSalesTaskDelayService;

    @RequestMapping("/sales/telSales")
    public String home(Model model, TelSalesSearchForm telSalesSearchForm) {
        List<TelSales> telSaless = telSalesService.getTelSalesList(telSalesSearchForm);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        List<TelSalesVO> telSalesVOs = new ArrayList<>();
        if (telSaless != null) {
            for (TelSales telSales : telSaless) {
                TelSalesVO telSalesVO = new TelSalesVO();
                telSalesVO.setId(telSales.getId());
                telSalesVO.setPhone(telSales.getPhone());
                telSalesVOs.add(telSalesVO);
            }
        }
        model.addAttribute("telSalesVOs", telSalesVOs);
        return "/sales/telSalesList";
    }

    @RequestMapping("/sales/telSales/toAdd")
    public String toAdd(Model model) {
        TelSales telSales = new TelSales();
        model.addAttribute("telSales", telSales);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        return "/sales/telSalesAdd";
    }

    @RequestMapping("/sales/telSales/add")
    public String add(TelSales telSales) {
        telSales.setState(ConstantCfg.ORDER_STATE_INITIAL);
        telSales.setCreator(0);
        telSales.setCreateTime(new Date());
        telSalesService.save(telSales);
        return "redirect:/sales/telSales";
    }

    @RequestMapping("/sales/telSales/toModify")
    public String toModify(Model model, Long id) {
        TelSales telSales = telSalesService.getTelSalesById(id);
        model.addAttribute("telSales", telSales);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        return "/sales/telSalesAdd";
    }

    @RequestMapping("/sales/telSales/modify")
    public String modify(TelSales telSales, Long id) {
        TelSales oldTelSales = telSalesService.getTelSalesById(id);
        oldTelSales.setResult(telSales.getResult());
        oldTelSales.setTaskDelay(telSales.getTaskDelay());
        oldTelSales.setMarkDesc(telSales.getMarkDesc());
        oldTelSales.setHistDesc(telSales.getHistDesc());
        oldTelSales.setUpdator(0);
        oldTelSales.setUpdateTime(new Date());
        telSalesService.merge(oldTelSales);
        return "redirect:/sales/telSales/toModify?id=" + id;
    }

    @RequestMapping("/sales/telSales/delete")
    public String delete(Long id) {
        TelSales oldTelSales = telSalesService.getTelSalesById(id);
        oldTelSales.setState(100);
        oldTelSales.setUpdator(0);
        oldTelSales.setUpdateTime(new Date());
        telSalesService.merge(oldTelSales);
        return "redirect:/sales/telSales";
    }
}