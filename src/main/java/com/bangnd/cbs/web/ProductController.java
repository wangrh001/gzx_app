package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.form.ProductSearchForm;
import com.bangnd.cbs.service.ProductBankIdService;
import com.bangnd.cbs.service.ProductProductStateService;
import com.bangnd.cbs.service.ProductProductTypeService;
import com.bangnd.cbs.service.ProductService;
import com.bangnd.cbs.vo.ProductVO;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.BusinessTypeService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * form表单提交 Date类型数据绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/cbs/product")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, ProductSearchForm productSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<Product> pages = productService.getProductList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,productSearchForm);
        model.addAttribute("bankIds", productBankIdService.getAll());
        model.addAttribute("productTypes", productProductTypeService.getAll());
        model.addAttribute("productStates", productProductStateService.getAll());
        model.addAttribute("busiTypes", businessTypeService.getAll());
        List<ProductVO> productVOs = new ArrayList<>();
        if (pages != null) {
            for (Product product : pages) {
                ProductVO productVO = new ProductVO();
                productVO.setId(product.getId());
                productVO.setProductName(product.getProductName());
                productVOs.add(productVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
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
        return "/cbs/productEdit";
    }

    @RequestMapping("/cbs/product/modify")
    public String modify(Product product, int id) {
        Product oldProduct = productService.getProductById(Long.valueOf(product.getId()).intValue());
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
        return "redirect:/cbs/product/";
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