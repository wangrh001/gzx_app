package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.Account;
import com.bangnd.finance.service.*;
import com.bangnd.finance.form.AccountSearchForm;

import java.util.*;

import com.bangnd.finance.repository.AccountRepository;
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
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountList(AccountSearchForm accountSearchForm) {
        Specification specification = new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (accountSearchForm.getAccountNames() != null && !"".equals(accountSearchForm.getAccountNames())) {
                    predicates.add(cb.like(root.get("accountNames").as(String.class), "%" + accountSearchForm.getAccountNames() + "%"));
                }
                if (accountSearchForm.getBank() != null && !"".equals(accountSearchForm.getBank())) {
                    if ("0".equals(accountSearchForm.getBank())) {
                        predicates.add(cb.notEqual(root.get("bank"), accountSearchForm.getBank()));
                    } else {
                        predicates.add(cb.equal(root.get("bank"), accountSearchForm.getBank()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return accountRepository.findAll(specification);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void merge(Account account) {
        accountRepository.save(account);
    }
}