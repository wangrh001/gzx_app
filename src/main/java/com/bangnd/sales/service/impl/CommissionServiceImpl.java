package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.Commission;
import com.bangnd.sales.service.*;
import com.bangnd.sales.form.CommissionSearchForm;

import java.util.*;

import com.bangnd.sales.repository.CommissionRepository;
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
public class CommissionServiceImpl implements CommissionService {
    @Autowired
    private CommissionRepository commissionRepository;

    public List<Commission> getCommissionList(CommissionSearchForm commissionSearchForm) {
        Specification specification = new Specification<Commission>() {
            @Override
            public Predicate toPredicate(Root<Commission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (commissionSearchForm.getBusinessType() != null && !"".equals(commissionSearchForm.getBusinessType())) {
                    if ("0".equals(commissionSearchForm.getBusinessType())) {
                        predicates.add(cb.notEqual(root.get("businessType"), commissionSearchForm.getBusinessType()));
                    } else {
                        predicates.add(cb.equal(root.get("businessType"), commissionSearchForm.getBusinessType()));
                    }
                }
                if (commissionSearchForm.getProductType() != null && !"".equals(commissionSearchForm.getProductType())) {
                    if ("0".equals(commissionSearchForm.getProductType())) {
                        predicates.add(cb.notEqual(root.get("productType"), commissionSearchForm.getProductType()));
                    } else {
                        predicates.add(cb.equal(root.get("productType"), commissionSearchForm.getProductType()));
                    }
                }
                if (commissionSearchForm.getProductId() != null && !"".equals(commissionSearchForm.getProductId())) {
                    predicates.add(cb.like(root.get("productId").as(String.class), "%" + commissionSearchForm.getProductId() + "%"));
                }
                if (commissionSearchForm.getChannelType() != null && !"".equals(commissionSearchForm.getChannelType())) {
                    if ("0".equals(commissionSearchForm.getChannelType())) {
                        predicates.add(cb.notEqual(root.get("channelType"), commissionSearchForm.getChannelType()));
                    } else {
                        predicates.add(cb.equal(root.get("channelType"), commissionSearchForm.getChannelType()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return commissionRepository.findAll(specification);
    }

    @Override
    public void save(Commission commission) {
        commissionRepository.save(commission);
    }

    @Override
    public Commission getCommissionById(long id) {
        return commissionRepository.findById(id);
    }

    @Override
    public void merge(Commission commission) {
        commissionRepository.save(commission);
    }
}