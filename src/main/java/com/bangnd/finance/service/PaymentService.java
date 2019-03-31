package com.bangnd.finance.service;

import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.form.PaymentSearchForm;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PaymentService {
    public Page<Payment> getPaymentList(Integer pageNum, int size, PaymentSearchForm paymentSearchForm);

    public void save(Payment payment);

    public Payment getPaymentById(long id);

    public void merge(Payment payment);

    public List<Payment> getPaymentListByOrderProdId(long id);

    public Payment getPaymentByOrderIdAndFeeType(long orderId, int feeType);

    public BigDecimal getSumIncome(Date date);
    public BigDecimal getSumExpend(Date date);
    public BigDecimal getSumCashIn(Date date);
    public BigDecimal getSumCashOut(Date date);

}