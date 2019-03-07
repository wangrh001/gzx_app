package com.bangnd.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.crm.web.*;
import com.bangnd.crm.entity.*;
import com.bangnd.crm.form.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.service.impl.*;
import com.bangnd.crm.vo.*;

@Controller
public class CustController {
    @Resource
    private CustService custService;
    @Resource
    CustCityService custCityService;
    @Resource
    CustSexService custSexService;
    @Resource
    CustSalesStateService custSalesStateService;
    @Resource
    CustInfoOriginalService custInfoOriginalService;
    @Resource
    CustWhyBorrowService custWhyBorrowService;
    @Resource
    CustJobService custJobService;
    @Resource
    CustIsNewStockholderService custIsNewStockholderService;

    @RequestMapping("/crm/cust")
    public String home(Model model, CustSearchForm custSearchForm) {
        List<Cust> custs = custService.getCustList(custSearchForm);
        model.addAttribute("citys", custCityService.getAll());
        model.addAttribute("sexs", custSexService.getAll());
        model.addAttribute("salesStates", custSalesStateService.getAll());
        model.addAttribute("infoOriginals", custInfoOriginalService.getAll());
        model.addAttribute("whyBorrows", custWhyBorrowService.getAll());
        model.addAttribute("jobs", custJobService.getAll());
        model.addAttribute("isNewStockholders", custIsNewStockholderService.getAll());
        List<CustVO> custVOs = new ArrayList<>();
        if (custs != null) {
            for (Cust cust : custs) {
                CustVO custVO = new CustVO();
                custVO.setId(cust.getId());
                custVO.setName(cust.getName());
                custVOs.add(custVO);
            }
        }
        model.addAttribute("custVOs", custVOs);
        return "/crm/custList";
    }

    @RequestMapping("/crm/cust/toAdd")
    public String toAdd(Model model) {
        Cust cust = new Cust();
        model.addAttribute("cust", cust);
        model.addAttribute("citys", custCityService.getAll());
        model.addAttribute("sexs", custSexService.getAll());
        model.addAttribute("salesStates", custSalesStateService.getAll());
        model.addAttribute("infoOriginals", custInfoOriginalService.getAll());
        model.addAttribute("whyBorrows", custWhyBorrowService.getAll());
        model.addAttribute("jobs", custJobService.getAll());
        model.addAttribute("isNewStockholders", custIsNewStockholderService.getAll());
        return "/crm/custAdd";
    }

    @RequestMapping("/crm/cust/add")
    public String add(Cust cust) {
        cust.setState(ConstantCfg.ORDER_STATE_INITIAL);
        cust.setCreator(0);
        cust.setCreateTime(new Date());
        custService.save(cust);
        return "redirect:/crm/cust";
    }

    @RequestMapping("/crm/cust/toModify")
    public String toModify(Model model, Long id) {
        Cust cust = custService.getCustById(id);
        model.addAttribute("cust", cust);
        model.addAttribute("citys", custCityService.getAll());
        model.addAttribute("sexs", custSexService.getAll());
        model.addAttribute("salesStates", custSalesStateService.getAll());
        model.addAttribute("infoOriginals", custInfoOriginalService.getAll());
        model.addAttribute("whyBorrows", custWhyBorrowService.getAll());
        model.addAttribute("jobs", custJobService.getAll());
        model.addAttribute("isNewStockholders", custIsNewStockholderService.getAll());
        return "/crm/custAdd";
    }

    @RequestMapping("/crm/cust/modify")
    public String modify(Cust cust, Long id) {
        Cust oldCust = custService.getCustById(id);
        oldCust.setName(cust.getName());
        oldCust.setBirthday(cust.getBirthday());
        oldCust.setCertiCode(cust.getCertiCode());
        oldCust.setPhone(cust.getPhone());
        oldCust.setCity(cust.getCity());
        oldCust.setAddress(cust.getAddress());
        oldCust.setCardNo(cust.getCardNo());
        oldCust.setSex(cust.getSex());
        oldCust.setSalesState(cust.getSalesState());
        oldCust.setInfoOriginal(cust.getInfoOriginal());
        oldCust.setWhyBorrow(cust.getWhyBorrow());
        oldCust.setJob(cust.getJob());
        oldCust.setIsNewStockholder(cust.getIsNewStockholder());
        oldCust.setBeStockholderMonths(cust.getBeStockholderMonths());
        oldCust.setUpdator(0);
        oldCust.setUpdateTime(new Date());
        custService.merge(oldCust);
        return "redirect:/crm/cust/toModify?id=" + id;
    }

    @RequestMapping("/crm/cust/delete")
    public String delete(Long id) {
        Cust oldCust = custService.getCustById(id);
        oldCust.setState(100);
        oldCust.setUpdator(0);
        oldCust.setUpdateTime(new Date());
        custService.merge(oldCust);
        return "redirect:/crm/cust";
    }
}