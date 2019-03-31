package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.form.PaymentSearchForm;
import com.bangnd.finance.repository.PaymentRepository;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Page<Payment> getPaymentList(Integer pageNum, int size, PaymentSearchForm paymentSearchForm) {
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
                } else {
                    //默认去未核销的
                    predicates.add(cb.equal(root.get("offset"), 2));
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
                        predicates.add(cb.equal(root.get("payState").as(Integer.class), paymentSearchForm.getPayState()));
                    }
                } else {
                    predicates.add(cb.notEqual(root.get("payState").as(Integer.class), new Integer(7)));
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

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Payment> qyPage = this.paymentRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public void save(Payment payment) {
        payment.setPosted("N");
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

    @Override
    public List<Payment> getPaymentListByOrderProdId(long id) {
        return paymentRepository.findAllByorderProductId(id);
    }

    @Override
    public Payment getPaymentByOrderIdAndFeeType(long orderId, int feeType) {
        Payment payment = null;
        try {
            return paymentRepository.findPaymentByOrderIdAndFeeType(orderId, feeType, ConstantCfg.OFF_SET_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public BigDecimal getSumIncome(Date date) {
        String feeType = "(1,3,9,10,11,30)";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return paymentRepository.findAllByDateAndFeeType(date,calendar.getTime(),feeType);
    }

    @Override
    public BigDecimal getSumExpend(Date date) {
        String feeType = "(2,5,6,7)";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return paymentRepository.findAllByDateAndFeeType(date,calendar.getTime(),feeType);
    }

    @Override
    public BigDecimal getSumCashIn(Date date) {
        String feeType = "(13,14,15,16,17,18,28,31)";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return paymentRepository.findAllByDateAndFeeType(date,calendar.getTime(),feeType);
    }

    @Override
    public BigDecimal getSumCashOut(Date date) {
        String feeType = "(8,12,19,23,24,25,29)";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return paymentRepository.findAllByDateAndFeeType(date,calendar.getTime(),feeType);
    }
}