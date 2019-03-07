package com.bangnd.cbs.web;

import com.bangnd.util.entity.BusinessType;
import com.bangnd.util.service.BusinessTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.cbs.web.*;
import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.form.*;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.service.impl.*;
import com.bangnd.cbs.vo.*;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    ProductBankIdService productBankIdService;
    @Resource
    ProductProductTypeService productProductTypeService;

    @Resource
    ProductProductStateService productProductStateService;
    @Resource
    BusinessTypeService businessTypeService;

    @RequestMapping("/cbs/product")
    public String home(Model model, ProductSearchForm productSearchForm) {
        List<Product> products = productService.getProductList(productSearchForm);
        model.addAttribute("bankIds", productBankIdService.getAll());
        model.addAttribute("productTypes", productProductTypeService.getAll());
        model.addAttribute("productStates", productProductStateService.getAll());
        model.addAttribute("busiTypes", businessTypeService.getAll());
        List<ProductVO> productVOs = new ArrayList<>();
        if (products != null) {
            for (Product product : products) {
                ProductVO productVO = new ProductVO();
                productVO.setId(product.getId());
                productVO.setProductName(product.getProductName());
                productVOs.add(productVO);
            }
        }
        model.addAttribute("productVOs", productVOs);
        return "/cbs/productList";
    }

    @RequestMapping("/cbs/product/toAdd")
    public String toAdd(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("bankIds", productBankIdService.getAll());
        model.addAttribute("productTypes", productProductTypeService.getAll());
        model.addAttribute("productStates", productProductStateService.getAll());
        model.addAttribute("busiTypes", businessTypeService.getAll());
        return "/cbs/productAdd";
    }

    @RequestMapping("/cbs/product/add")
    public String add(Product product) {
        product.setState(ConstantCfg.ORDER_STATE_INITIAL);
        product.setCreator(0);
        product.setCreateTime(new Date());
        productService.save(product);
        return "redirect:/cbs/product";
    }

    @RequestMapping("/cbs/product/toModify")
    public String toModify(Model model, int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("bankIds", productBankIdService.getAll());
        model.addAttribute("productTypes", productProductTypeService.getAll());
        model.addAttribute("productStates", productProductStateService.getAll());
        model.addAttribute("busiTypes", businessTypeService.getAll());
        return "/cbs/productAdd";
    }

    @RequestMapping("/cbs/product/modify")
    public String modify(Product product, int id) {
        Product oldProduct = productService.getProductById(id);
        oldProduct.setProductName(product.getProductName());
        oldProduct.setBankId(product.getBankId());
        oldProduct.setBusiType(product.getBusiType());
        oldProduct.setProductType(product.getProductType());
        oldProduct.setBrokerage(product.getBrokerage());
        oldProduct.setInterest(product.getInterest());
        oldProduct.setProductState(product.getProductState());
        oldProduct.setLawFee(product.getLawFee());
        oldProduct.setFairFee(product.getFairFee());
        oldProduct.setLicenseFee(product.getLicenseFee());
        oldProduct.setBeginDate(product.getBeginDate());
        oldProduct.setEndDate(product.getEndDate());
        oldProduct.setUpdator(0);
        oldProduct.setUpdateTime(new Date());
        productService.merge(oldProduct);
        return "redirect:/cbs/product/toModify?id=" + id;
    }

    @RequestMapping("/cbs/product/delete")
    public String delete(int id) {
        Product oldProduct = productService.getProductById(id);
        oldProduct.setState(100);
        oldProduct.setUpdator(0);
        oldProduct.setUpdateTime(new Date());
        productService.merge(oldProduct);
        return "redirect:/cbs/product";
    }
}