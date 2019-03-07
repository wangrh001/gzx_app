package com.bangnd.batch.jobs.finance;

import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.repository.OrderProductRepository;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//生成费用流水帐
public class FeeHandler {

    private PaymentRepository paymentRepository;

    private OrderProductRepository orderProductRepository;

    //1、计算应收利息，并插入费用表
    //2、计算应付利息，并插入费用表
    //3、计算应收手续费，并插入费用表
    //4、计算应付手续费，并插入费用表
    //5、插入应收本金
    //6、差人应付本金
    //7、插入人力应付费用（比较复杂，专门计算类）
    //8、插入佣金应付费用（比较复杂，专门计算类）
    public void cbsFee() {
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList = orderProductRepository.findAllByProductId();
        if (orderProductList != null) {
            for (OrderProduct orderProduct : orderProductList) {
            }
        }

    }

    //生成费用数据
    private void createPayment(BigDecimal amount,
                               int inOut,
                               int payType,
                               long orderId,
                               int payDateType,
                               Date paydate) {
        Payment payment = new Payment();
        payment.setInOut(inOut);
        payment.setAmount(amount);
        payment.setPayDate(paydate);
        payment.setPayType(payType);
        payment.setOrderId(orderId);
        payment.setCreateTime(new Date());
        payment.setCreator(0);
        payment.setState(1);
        paymentRepository.save(payment);
    }

}
