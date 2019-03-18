package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountingRule;
import com.bangnd.finance.form.AccountingRuleSearchForm;
import com.bangnd.finance.repository.AccountingRuleRepository;
import com.bangnd.finance.service.AccountingRuleService;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountingRuleServiceImpl implements AccountingRuleService {
    @Autowired
    private AccountingRuleRepository accountingRuleRepository;

    public Page<AccountingRule> getAccountingRuleList(Integer pageNum, int size, AccountingRuleSearchForm accountingRuleSearchForm) {
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
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<AccountingRule> qyPage = this.accountingRuleRepository.findAll(specification, pageable);
        return qyPage;
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