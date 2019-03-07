package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.*;
import com.bangnd.finance.form.PaymentSearchForm;

import java.util.*;

import com.bangnd.finance.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPaymentList(PaymentSearchForm paymentSearchForm) {
        Specification specification = new Specification<Payment>() {
            @Override
            public Predicate toPredicate(Root<Payment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (paymentSearchForm.getOffset() != null && !"".equals(paymentSearchForm.getOffset())) {
                    if ("0".equals(paymentSearchForm.getOffset())) {
                        predicates.add(cb.notEqual(root.get("offset"), paymentSearchForm.getOffset()));
                    } else {
                        predicates.add(cb.equal(root.get("offset"), paymentSearchForm.getOffset()));
                    }
                }
                if (paymentSearchForm.getInOut() != null && !"".equals(paymentSearchForm.getInOut())) {
                    if ("0".equals(paymentSearchForm.getInOut())) {
                        predicates.add(cb.notEqual(root.get("inOut"), paymentSearchForm.getInOut()));
                    } else {
                        predicates.add(cb.equal(root.get("inOut"), paymentSearchForm.getInOut()));
                    }
                }
                if (paymentSearchForm.getPayType() != null && !"".equals(paymentSearchForm.getPayType())) {
                    if ("0".equals(paymentSearchForm.getPayType())) {
                        predicates.add(cb.notEqual(root.get("payType"), paymentSearchForm.getPayType()));
                    } else {
                        predicates.add(cb.equal(root.get("payType"), paymentSearchForm.getPayType()));
                    }
                }
                if (paymentSearchForm.getPayDateStart() != null && !"".equals(paymentSearchForm.getPayDateStart()) && paymentSearchForm.getPayDateEnd() != null && !"".equals(paymentSearchForm.getPayDateEnd())) {
                    predicates.add(cb.between(root.get("payDate").as(Date.class), paymentSearchForm.getPayDateStart(), paymentSearchForm.getPayDateEnd()));
                }
                if (paymentSearchForm.getAccountName() != null && !"".equals(paymentSearchForm.getAccountName())) {
                    predicates.add(cb.like(root.get("accountName").as(String.class), "%" + paymentSearchForm.getAccountName() + "%"));
                }
                if (paymentSearchForm.getPayState() != null && !"".equals(paymentSearchForm.getPayState())) {
                    if ("0".equals(paymentSearchForm.getPayState())) {
                        predicates.add(cb.notEqual(root.get("payState"), paymentSearchForm.getPayState()));
                    } else {
                        predicates.add(cb.equal(root.get("payState"), paymentSearchForm.getPayState()));
                    }
                }
                if (paymentSearchForm.getIfReal() != null && !"".equals(paymentSearchForm.getIfReal())) {
                    if ("0".equals(paymentSearchForm.getIfReal())) {
                        predicates.add(cb.notEqual(root.get("ifReal"), paymentSearchForm.getIfReal()));
                    } else {
                        predicates.add(cb.equal(root.get("ifReal"), paymentSearchForm.getIfReal()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return paymentRepository.findAll(specification);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void merge(Payment payment) {
        paymentRepository.save(payment);
    }
}