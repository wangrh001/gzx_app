package com.bangnd.finance.service;

import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.form.PaymentSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PaymentService {
    public Page<Payment> getPaymentList(Integer pageNum, int size, PaymentSearchForm paymentSearchForm);

    public void save(Payment payment);

    public Payment getPaymentById(long id);

    public void merge(Payment payment);

    public List<Payment> getPaymentListByOrderProdId(long id);
}