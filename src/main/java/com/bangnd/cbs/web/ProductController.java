package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.service.RecommendProductService;
import com.bangnd.demo.entity.User;
import com.bangnd.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    RecommendProductService recommendProductService;

    @RequestMapping("/prod/recommendProd")
    public String list(Model model) {
        System.out.println("enter the product controller");
        List<Product> products=recommendProductService.recommendProducts(new Long(33));
        model.addAttribute("products", products);
        return "/order/orderAdd";
    }
}
