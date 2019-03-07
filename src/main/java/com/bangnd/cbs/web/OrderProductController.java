package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.entity.OrderProdCustRelation;
import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.service.*;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.PayWayService;
import com.bangnd.util.service.PeriodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class OrderProductController {
    @Resource
    OrderService orderService;
    @Resource
    OrderProductService orderProductService;
    @Resource
    OrderProdCustRelationService orderProdCustRelationService;
    @Resource
    CustomerService customerService;
    @Resource
    PayWayService payWayService;
    @Resource
    ProductService productService;
    @Resource
    PeriodTypeService periodTypeService;


    @RequestMapping("/orderProduct/add")
    public String saveOrderProduct(String orderId,
                                   String customer1,
                                   String customer2,
                                   String customer3,
                                   OrderProduct orderProduct) {
        orderProduct.setOrderId(new Long(orderId).longValue());
        orderProduct.setCreateTime(new Date());
        orderProduct.setCreator(0);
        orderProduct.setState(1);
        //添加产品之处的状态是方案已经匹配
        orderProduct.setOrderProdState(2);
        orderProductService.save(orderProduct);

        //这里才确认客户是什么身份
        System.out.println("customer1=" + customer1 + ";productId=" + orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation = new OrderProdCustRelation();
        orderProdCustRelation.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation.setCustomerId(new Long(customer1).longValue());
        orderProdCustRelation.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_1);
        orderProdCustRelationService.save(orderProdCustRelation);

        System.out.println("customer2=" + customer1 + ";productId=" + orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation2 = new OrderProdCustRelation();
        orderProdCustRelation2.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation2.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation2.setCustomerId(new Long(customer2).longValue());
        orderProdCustRelation2.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_2);
        orderProdCustRelationService.save(orderProdCustRelation2);

        System.out.println("customer3=" + customer1 + ";productId=" + orderProduct.getId());
        OrderProdCustRelation orderProdCustRelation3 = new OrderProdCustRelation();
        orderProdCustRelation3.setOrderId(new Long(orderId).longValue());
        orderProdCustRelation3.setOrderProductId(new Long(orderProduct.getId()).longValue());
        orderProdCustRelation3.setCustomerId(new Long(customer3).longValue());
        orderProdCustRelation3.setIdentityType(ConstantCfg.CUSTOMER_IDENTITY_TYPE_3);
        orderProdCustRelationService.save(orderProdCustRelation2);

        return "redirect:/order/toAdd?orderId=" + orderId;
    }

    @RequestMapping("/orderProduct/delete")
    public String delete(long id) {
        orderProductService.delete(id);
        OrderProduct orderProduct = orderProductService.findById(id);
        return "redirect:/order/toAdd?orderId=" + orderProduct.getOrderId();
    }

    @RequestMapping("/orderProduct/toModify")
    public String toModify(Model model, long id) {
        OrderProduct orderProduct = orderProductService.findById(id);
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        List<Customer> customerList = customerService.findCustomerByOrderId(orderProduct.getOrderId());
        if (customerList != null && customerList.size() > 0) {
            model.addAttribute("customerList", customerList);
        }
        Order order = orderService.findOrderById(orderProduct.getOrderId());
        model.addAttribute("products", productService.getProductsByType(order.getBusinessType()));

        List<OrderProdCustRelation> orderProdCustRelationList = orderProdCustRelationService.getObjsByOrderProdId(id);
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        if (orderProdCustRelationList != null) {
            for (OrderProdCustRelation opcr : orderProdCustRelationList) {
                if (opcr.getIdentityType() == 1) {
                    customer1 = customerService.findCustomerById(opcr.getCustomerId());
                } else if (opcr.getIdentityType() == 2) {
                    customer2 = customerService.findCustomerById(opcr.getCustomerId());
                } else if (opcr.getIdentityType() == 3) {
                    customer3 = customerService.findCustomerById(opcr.getCustomerId());
                }
            }
        }
        model.addAttribute("customer1", customer1);
        model.addAttribute("customer2", customer2);
        model.addAttribute("customer3", customer3);
        model.addAttribute("orderProduct", orderProduct);
        return "/order/orderProductEdit";
    }

    @RequestMapping("/orderProduct/modify")
    public String modify(String customer1,
                         String customer2,
                         String customer3,
                         OrderProduct orderProduct) {
        OrderProduct oldOrderProduct = orderProductService.findById(orderProduct.getId());
        //可以换产品
        oldOrderProduct.setProductId(orderProduct.getProductId());
        //可以换产品的计划贷款属性
        oldOrderProduct.setPlanPeriodType(orderProduct.getPlanPeriodType());
        oldOrderProduct.setPlanPayWay(orderProduct.getPlanPayWay());
        oldOrderProduct.setPlanAmount(orderProduct.getPlanAmount());
        oldOrderProduct.setPlanInterest(orderProduct.getPlanInterest());
        oldOrderProduct.setPlanPeriodNum(orderProduct.getPlanPeriodNum());
        oldOrderProduct.setPlanSource(orderProduct.getPlanSource());
        //可以修改产品的真实贷款属性
        oldOrderProduct.setRealPeriodType(orderProduct.getRealPeriodType());
        oldOrderProduct.setRealPayWay(orderProduct.getRealPayWay());
        oldOrderProduct.setRealAmount(orderProduct.getRealAmount());
        oldOrderProduct.setRealInterest(orderProduct.getRealInterest());
        oldOrderProduct.setRealPeriodNum(orderProduct.getRealPeriodNum());
        oldOrderProduct.setRelationship(orderProduct.getRelationship());
        oldOrderProduct.setApproveTime(orderProduct.getApproveTime());
        oldOrderProduct.setUpdateTime(new Date());
        oldOrderProduct.setUpdator(0);
        orderProductService.save(oldOrderProduct);
        System.out.println("customer1=" + customer1 + ";customer2=" + customer2 + ";customer3=" + customer3);
        if (!"".equals(customer1) && customer1 != null) {
            System.out.println("orderprodId=" + orderProduct.getId());
            //可以修改贷款人
            OrderProdCustRelation oldOrderProdCustRelation1 =
                    orderProdCustRelationService.findObjByOrderProductId(orderProduct.getId(), ConstantCfg.CUSTOMER_IDENTITY_TYPE_1);
            if (oldOrderProdCustRelation1 != null) {
                oldOrderProdCustRelation1.setCustomerId(Long.valueOf(customer1).longValue());
                orderProdCustRelationService.save(oldOrderProdCustRelation1);
            }
        }
        if (!"".equals(customer1) && customer2 != null) {
            //可以修改抵押人
            OrderProdCustRelation oldOrderProdCustRelation2 =
                    orderProdCustRelationService.findObjByOrderProductId(orderProduct.getId(), ConstantCfg.CUSTOMER_IDENTITY_TYPE_2);
            if (oldOrderProdCustRelation2 != null) {
                oldOrderProdCustRelation2.setCustomerId(Long.valueOf(customer2).longValue());
                orderProdCustRelationService.save(oldOrderProdCustRelation2);
            }
        }

        if (!"".equals(customer1) && customer3 != null) {
            //可以修改连带借款人
            OrderProdCustRelation oldOrderProdCustRelation3 =
                    orderProdCustRelationService.findObjByOrderProductId(orderProduct.getId(), ConstantCfg.CUSTOMER_IDENTITY_TYPE_3);
            if (oldOrderProdCustRelation3 != null) {
                oldOrderProdCustRelation3.setCustomerId(Long.valueOf(customer3).longValue());
                orderProdCustRelationService.save(oldOrderProdCustRelation3);
            }
        }
        //这里用oldOrderProducut是因为，orderProduct这个对象在html中没有hidden orderId这个属性，故无法带过来
        return "redirect:/order/toAdd?orderId=" + oldOrderProduct.getOrderId();

    }
}
