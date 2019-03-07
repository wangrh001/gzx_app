package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.service.*;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;

import java.util.*;

import com.bangnd.sales.repository.PerformanceCommissionRepository;
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
public class PerformanceCommissionServiceImpl implements PerformanceCommissionService {
    @Autowired
    private PerformanceCommissionRepository performanceCommissionRepository;

    public List<PerformanceCommission> getPerformanceCommissionList(PerformanceCommissionSearchForm performanceCommissionSearchForm) {
        Specification specification = new Specification<PerformanceCommission>() {
            @Override
            public Predicate toPredicate(Root<PerformanceCommission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (performanceCommissionSearchForm.getMonth() != null && !"".equals(performanceCommissionSearchForm.getMonth())) {
                    predicates.add(cb.like(root.get("month").as(String.class), "%" + performanceCommissionSearchForm.getMonth() + "%"));
                }
                if (performanceCommissionSearchForm.getAgentName() != null && !"".equals(performanceCommissionSearchForm.getAgentName())) {
                    predicates.add(cb.like(root.get("agentName").as(String.class), "%" + performanceCommissionSearchForm.getAgentName() + "%"));
                }
                if (performanceCommissionSearchForm.getProcess() != null && !"".equals(performanceCommissionSearchForm.getProcess())) {
                    if ("0".equals(performanceCommissionSearchForm.getProcess())) {
                        predicates.add(cb.notEqual(root.get("process"), performanceCommissionSearchForm.getProcess()));
                    } else {
                        predicates.add(cb.equal(root.get("process"), performanceCommissionSearchForm.getProcess()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return performanceCommissionRepository.findAll(specification);
    }

    @Override
    public void save(PerformanceCommission performanceCommission) {
        performanceCommissionRepository.save(performanceCommission);
    }

    @Override
    public PerformanceCommission getPerformanceCommissionById(long id) {
        return performanceCommissionRepository.findById(id);
    }

    @Override
    public void merge(PerformanceCommission performanceCommission) {
        performanceCommissionRepository.save(performanceCommission);
    }
}