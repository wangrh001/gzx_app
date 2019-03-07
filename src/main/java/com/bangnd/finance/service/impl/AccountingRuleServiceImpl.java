package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountingRule;
import com.bangnd.finance.service.*;
import com.bangnd.finance.form.AccountingRuleSearchForm;

import java.util.*;

import com.bangnd.finance.repository.AccountingRuleRepository;
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
public class AccountingRuleServiceImpl implements AccountingRuleService {
    @Autowired
    private AccountingRuleRepository accountingRuleRepository;

    public List<AccountingRule> getAccountingRuleList(AccountingRuleSearchForm accountingRuleSearchForm) {
        Specification specification = new Specification<AccountingRule>() {
            @Override
            public Predicate toPredicate(Root<AccountingRule> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (accountingRuleSearchForm.getFeeType() != null && !"".equals(accountingRuleSearchForm.getFeeType())) {
                    if ("0".equals(accountingRuleSearchForm.getFeeType())) {
                        predicates.add(cb.notEqual(root.get("feeType"), accountingRuleSearchForm.getFeeType()));
                    } else {
                        predicates.add(cb.equal(root.get("feeType"), accountingRuleSearchForm.getFeeType()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return accountingRuleRepository.findAll(specification);
    }

    @Override
    public void save(AccountingRule accountingRule) {
        accountingRuleRepository.save(accountingRule);
    }

    @Override
    public AccountingRule getAccountingRuleById(long id) {
        return accountingRuleRepository.findById(id);
    }

    @Override
    public void merge(AccountingRule accountingRule) {
        accountingRuleRepository.save(accountingRule);
    }
}