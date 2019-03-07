package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.TelSales;
import com.bangnd.sales.service.*;
import com.bangnd.sales.form.TelSalesSearchForm;

import java.util.*;

import com.bangnd.sales.repository.TelSalesRepository;
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
public class TelSalesServiceImpl implements TelSalesService {
    @Autowired
    private TelSalesRepository telSalesRepository;

    public List<TelSales> getTelSalesList(TelSalesSearchForm telSalesSearchForm) {
        Specification specification = new Specification<TelSales>() {
            @Override
            public Predicate toPredicate(Root<TelSales> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (telSalesSearchForm.getPhone() != null && !"".equals(telSalesSearchForm.getPhone())) {
                    predicates.add(cb.like(root.get("phone").as(String.class), "%" + telSalesSearchForm.getPhone() + "%"));
                }
                if (telSalesSearchForm.getTaskDateStart() != null && !"".equals(telSalesSearchForm.getTaskDateStart()) && telSalesSearchForm.getTaskDateEnd() != null && !"".equals(telSalesSearchForm.getTaskDateEnd())) {
                    predicates.add(cb.between(root.get("taskDate").as(Date.class), telSalesSearchForm.getTaskDateStart(), telSalesSearchForm.getTaskDateEnd()));
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return telSalesRepository.findAll(specification);
    }

    @Override
    public void save(TelSales telSales) {
        telSalesRepository.save(telSales);
    }

    @Override
    public TelSales getTelSalesById(long id) {
        return telSalesRepository.findById(id);
    }

    @Override
    public void merge(TelSales telSales) {
        telSalesRepository.save(telSales);
    }
}