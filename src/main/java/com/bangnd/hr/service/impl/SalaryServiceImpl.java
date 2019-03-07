package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.Salary;
import com.bangnd.hr.service.*;
import com.bangnd.hr.form.SalarySearchForm;

import java.util.*;

import com.bangnd.hr.repository.SalaryRepository;
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
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> getSalaryList(SalarySearchForm salarySearchForm) {
        Specification specification = new Specification<Salary>() {
            @Override
            public Predicate toPredicate(Root<Salary> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (salarySearchForm.getEmpName() != null && !"".equals(salarySearchForm.getEmpName())) {
                    predicates.add(cb.like(root.get("empName").as(String.class), "%" + salarySearchForm.getEmpName() + "%"));
                }
                if (salarySearchForm.getMonth() != null && !"".equals(salarySearchForm.getMonth())) {
                    predicates.add(cb.like(root.get("month").as(String.class), "%" + salarySearchForm.getMonth() + "%"));
                }
                if (salarySearchForm.getExtendState() != null && !"".equals(salarySearchForm.getExtendState())) {
                    if ("0".equals(salarySearchForm.getExtendState())) {
                        predicates.add(cb.notEqual(root.get("extendState"), salarySearchForm.getExtendState()));
                    } else {
                        predicates.add(cb.equal(root.get("extendState"), salarySearchForm.getExtendState()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return salaryRepository.findAll(specification);
    }

    @Override
    public void save(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public Salary getSalaryById(long id) {
        return salaryRepository.findById(id);
    }

    @Override
    public void merge(Salary salary) {
        salaryRepository.save(salary);
    }
}