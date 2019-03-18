package com.bangnd.sales.web;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.service.ProductService;
import com.bangnd.hr.service.PositionService;
import com.bangnd.sales.entity.Commission;
import com.bangnd.sales.form.CommissionSearchForm;
import com.bangnd.sales.service.*;
import com.bangnd.sales.vo.CommissionVO;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.BusinessTypeService;
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
public class CommissionController {
    @Resource
    private CommissionService commissionService;
    @Resource
    BusinessTypeService businessTypeService;
    @Resource
    CommissionProductTypeService commissionProductTypeService;
    @Resource
    CommissionLevelService commissionLevelService;

    @Resource
    CommissionWayService commissionWayService;
    @Resource
    CommissionBaseTypeService commissionBaseTypeService;
    @Resource
    CommissionChannelTypeService commissionChannelTypeService;
    @Resource
    PositionService positionService;
    @Resource
    ProductService productService;

    @RequestMapping("/sales/commission")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, CommissionSearchForm commissionSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<Commission> pages = commissionService.getCommissionList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,commissionSearchForm);
        model.addAttribute("businessTypes", businessTypeService.getAll());
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", positionService.getAll());
        model.addAttribute("ways", commissionWayService.getAll());
        model.addAttribute("baseTypes", commissionBaseTypeService.getAll());
        model.addAttribute("channelTypes", commissionChannelTypeService.getAll());
        List<CommissionVO> commissionVOs = new ArrayList<>();
        if (pages != null) {
            for (Commission commission : pages) {
                CommissionVO commissionVO = new CommissionVO();
                commissionVO.setId(commission.getId());
                commissionVO.setBusinessTypeName((businessTypeService.findOneById(commission.getBusinessType())).getName());
                commissionVO.setProductName(productService.getProductById(commission.getProductId()).getProductName());
                commissionVO.setLevelName(commissionLevelService.getCommissionLevelById(commission.getLevel()).getName());
                commissionVO.setTypeName(positionService.getPositionById(commission.getType()).getName());
                commissionVO.setPercent(commission.getPercent());
                commissionVOs.add(commissionVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
        model.addAttribute("commissionVOs", commissionVOs);
        return "/sales/commissionList";
    }

    @RequestMapping("/sales/commission/toAdd")
    public String toAdd(Model model) {
        Commission commission = new Commission();
        model.addAttribute("commission", commission);
        model.addAttribute("businessTypes", businessTypeService.getAll());
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", positionService.getAll());
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
        model.addAttribute("businessTypes", businessTypeService.getAll());
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("levels", commissionLevelService.getAll());
        model.addAttribute("types", positionService.getAll());
        model.addAttribute("ways", commissionWayService.getAll());
        model.addAttribute("baseTypes", commissionBaseTypeService.getAll());
        model.addAttribute("channelTypes", commissionChannelTypeService.getAll());
        return "/sales/commissionEdit";
    }

    @RequestMapping("/sales/commission/modify")
    public String modify(Commission commission, Long id) {
        Commission oldCommission = commissionService.getCommissionById(id);
        oldCommission.setBusinessType(commission.getBusinessType());
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
        return "redirect:/sales/commission";
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