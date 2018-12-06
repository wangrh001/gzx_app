package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.OrderProdCustRelation;
import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.service.OrderProdCustRelationService;
import com.bangnd.cbs.service.OrderProductService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class OrderProductController {
    @Resource
    OrderProductService orderProductService;
    @Resource
    OrderProdCustRelationService orderProdCustRelationService;

    @RequestMapping("/orderProduct/add")
    public String saveOrderProduct(String orderId,
                                   String customer1,
                                   String customer2,
                                   String customer3,
                                   OrderProduct orderProduct){
        orderProduct.setOrderId(new Long(orderId).longValue());
        orderProduct.setCreateTime(new Date());
        orderProduct.setCreator(0);
        orderProduct.setOrderProdState(1);
        orderProductService.save(orderProduct);

        //这里才确认客户是什么身份
        System.out.println("customer1="+customer1+";productId="+orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation = new OrderProdCustRelation();
        orderProdCustRelation.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation.setCustomerId(new Long(customer1).longValue());
        orderProdCustRelation.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_1);
        orderProdCustRelationService.save(orderProdCustRelation);

        System.out.println("customer2="+customer1+";productId="+orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation2 = new OrderProdCustRelation();
        orderProdCustRelation2.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation2.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation2.setCustomerId(new Long(customer2).longValue());
        orderProdCustRelation2.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_2);
        orderProdCustRelationService.save(orderProdCustRelation2);

        System.out.println("customer3="+customer1+";productId="+orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation3 = new OrderProdCustRelation();
        orderProdCustRelation3.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation3.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation3.setCustomerId(new Long(customer3).longValue());
        orderProdCustRelation3.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_3);
        orderProdCustRelationService.save(orderProdCustRelation2);

        return "redirect:/order/toAdd?orderId="+orderId;
    }

    @RequestMapping("/orderProduct/delete")
    public String delete(long id){
        orderProductService.delete(id);
        OrderProduct orderProduct = orderProductService.findById(id);
        return "redirect:/order/toAdd?orderId="+orderProduct.getOrderId();
    }
}
