//package com.bangnd.cbs.service.impl;
//
//import com.bangnd.cbs.entity.*;
//import com.bangnd.cbs.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.googlecode.aviator.AviatorEvaluator;
//import com.googlecode.aviator.Expression;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class RecommendProductServiceImpl implements RecommendProductService {
//    @Autowired
//    OrderService orderService;
//    @Autowired
//    CustMortgageService custMortgageService;
//    @Autowired
//    CustomerService customerService;
//    @Autowired
//    CustCreditService custCreditService;
//
//    @Override
//    public List<Product> recommendProducts(long orderId) {
//        Order order = orderService.findOrderById(orderId);
////        Customer customer = customerService.findCustomerById(order.getBorrowerId());
////        CustMortgage mortgage = mortgageService.findMortgageById(order.getMortgageId());
//        //CustomerCredit customerCredit = customerCreditService.findCustCreditById(customer.getCreditId());
//
//        //两种常见用法
//        //1、执行表达式
//        System.out.println("test the aviator"+AviatorEvaluator.execute("1+2"));
//
//        //2.1 先定义表达式
//        String expression = "a-(b-c)>100";
//        //2.2 编译表达式
//        Expression compiledExp = AviatorEvaluator.compile(expression);
//        Map<String, Object> env = new HashMap<String, Object>();
//        env.put("a", 100.3);
//        env.put("b", 45);
//        env.put("c", -199.100);
//        //2.3 执行表达式
//        Boolean result = (Boolean)compiledExp.execute(env);
//
//        System.out.println(result);  // false
//
//
//        return null;
//    }
//
//    @Override
//    public List<Product> recommendProtfolios(long orderId) {
//        return null;
//    }
//}
//package com.bangnd.cbs.service.impl;
//
//import com.bangnd.cbs.entity.*;
//import com.bangnd.cbs.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.googlecode.aviator.AviatorEvaluator;
//import com.googlecode.aviator.Expression;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class RecommendProductServiceImpl implements RecommendProductService {
//    @Autowired
//    OrderService orderService;
//    @Autowired
//    CustMortgageService custMortgageService;
//    @Autowired
//    CustomerService customerService;
//    @Autowired
//    CustCreditService custCreditService;
//
//    @Override
//    public List<Product> recommendProducts(long orderId) {
//        Order order = orderService.findOrderById(orderId);
////        Customer customer = customerService.findCustomerById(order.getBorrowerId());
////        CustMortgage mortgage = mortgageService.findMortgageById(order.getMortgageId());
//        //CustomerCredit customerCredit = customerCreditService.findCustCreditById(customer.getCreditId());
//
//        //两种常见用法
//        //1、执行表达式
//        System.out.println("test the aviator"+AviatorEvaluator.execute("1+2"));
//
//        //2.1 先定义表达式
//        String expression = "a-(b-c)>100";
//        //2.2 编译表达式
//        Expression compiledExp = AviatorEvaluator.compile(expression);
//        Map<String, Object> env = new HashMap<String, Object>();
//        env.put("a", 100.3);
//        env.put("b", 45);
//        env.put("c", -199.100);
//        //2.3 执行表达式
//        Boolean result = (Boolean)compiledExp.execute(env);
//
//        System.out.println(result);  // false
//
//
//        return null;
//    }
//
//    @Override
//    public List<Product> recommendProtfolios(long orderId) {
//        return null;
//    }
//}
