package com.bangnd.finance.service;

import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.form.PaymentSearchForm;

import java.util.List;

public interface PaymentService {
    public List<Payment> getPaymentList(PaymentSearchForm paymentSearchForm);

    public void save(Payment payment);

    public Payment getPaymentById(long id);

    public void merge(Payment payment);
}