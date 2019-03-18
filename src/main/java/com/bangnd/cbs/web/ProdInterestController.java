package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.ProdInterest;
import com.bangnd.cbs.form.ProdInterestSearchForm;
import com.bangnd.cbs.service.ProdInterestService;
import com.bangnd.cbs.service.ProductService;
import com.bangnd.cbs.vo.ProdInterestVO;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.PeriodTypeService;
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
public class ProdInterestController {
    @Resource
    private ProdInterestService prodInterestService;
    @Resource
    PeriodTypeService periodTypeService;
    @Resource
    ProductService productService;

    @RequestMapping("/cbs/prodInterest")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, ProdInterestSearchForm prodInterestSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<ProdInterest> pages = prodInterestService.getProdInterestList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,prodInterestSearchForm);
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("products",productService.getInterestProduct());
        List<ProdInterestVO> prodInterestVOs = new ArrayList<>();
        if (pages != null) {
            for (ProdInterest prodInterest : pages) {
                ProdInterestVO prodInterestVO = new ProdInterestVO();
                prodInterestVO.setId(prodInterest.getId());
                prodInterestVO.setInterest(prodInterest.getInterest());
                prodInterestVO.setProductName((productService.getProductById(prodInterest.getProductId())).getProductName());
                prodInterestVO.setPeriodTypeName((periodTypeService.getPeriodTypeById(prodInterest.getPeriodType())).getName());
                prodInterestVOs.add(prodInterestVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
        model.addAttribute("prodInterestVOs", prodInterestVOs);
        return "/cbs/prodInterestList";
    }

    @RequestMapping("/cbs/prodInterest/toAdd")
    public String toAdd(Model model) {
        ProdInterest prodInterest = new ProdInterest();
        model.addAttribute("prodInterest", prodInterest);
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("products",productService.getInterestProduct());
        return "/cbs/prodInterestAdd";
    }

    @RequestMapping("/cbs/prodInterest/add")
    public String add(ProdInterest prodInterest) {
        prodInterest.setState(ConstantCfg.ORDER_STATE_INITIAL);
        prodInterest.setCreator(0);
        prodInterest.setCreateTime(new Date());
        prodInterestService.save(prodInterest);
        return "redirect:/cbs/prodInterest";
    }

    @RequestMapping("/cbs/prodInterest/toModify")
    public String toModify(Model model, Long id) {
        ProdInterest prodInterest = prodInterestService.getProdInterestById(id);
        model.addAttribute("prodInterest", prodInterest);
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("products",productService.getInterestProduct());
        return "/cbs/prodInterestAdd";
    }

    @RequestMapping("/cbs/prodInterest/modify")
    public String modify(ProdInterest prodInterest, Long id) {
        ProdInterest oldProdInterest = prodInterestService.getProdInterestById(id);
        oldProdInterest.setProductId(prodInterest.getProductId());
        oldProdInterest.setPeriodType(prodInterest.getPeriodType());
        oldProdInterest.setInterest(prodInterest.getInterest());
        oldProdInterest.setBeginDate(prodInterest.getBeginDate());
        oldProdInterest.setEndDate(prodInterest.getEndDate());
        oldProdInterest.setUpdator(0);
        oldProdInterest.setUpdateTime(new Date());
        prodInterestService.merge(oldProdInterest);
        return "redirect:/cbs/prodInterest/toModify?id=" + id;
    }

    @RequestMapping("/cbs/prodInterest/delete")
    public String delete(Long id) {
        ProdInterest oldProdInterest = prodInterestService.getProdInterestById(id);
        oldProdInterest.setState(100);
        oldProdInterest.setUpdator(0);
        oldProdInterest.setUpdateTime(new Date());
        prodInterestService.merge(oldProdInterest);
        return "redirect:/cbs/prodInterest";
    }
}