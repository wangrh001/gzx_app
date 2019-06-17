package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.Cust;
import com.bangnd.crm.form.CustSearchForm;
import com.bangnd.crm.repository.CustRepository;
import com.bangnd.crm.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustRepository custRepository;

    public List<Cust> getCustList(CustSearchForm custSearchForm) {
        Specification specification = new Specification<Cust>() {
            @Override
            public Predicate toPredicate(Root<Cust> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (custSearchForm.getName() != null && !"".equals(custSearchForm.getName())) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + custSearchForm.getName() + "%"));
                }
                if (custSearchForm.getBirthday() != null && !"".equals(custSearchForm.getBirthday())) {
                    predicates.add(cb.like(root.get("birthday").as(String.class), "%" + custSearchForm.getBirthday() + "%"));
                }
                if (custSearchForm.getPhone() != null && !"".equals(custSearchForm.getPhone())) {
                    predicates.add(cb.like(root.get("phone").as(String.class), "%" + custSearchForm.getPhone() + "%"));
                }
                if (custSearchForm.getCity() != null && !"".equals(custSearchForm.getCity())) {
                    if ("-1".equals(custSearchForm.getCity())) {
                        predicates.add(cb.notEqual(root.get("city"), custSearchForm.getCity()));
                    } else {
                        predicates.add(cb.equal(root.get("city"), custSearchForm.getCity()));
                    }
                }
                if (custSearchForm.getSex() != null && !"".equals(custSearchForm.getSex())) {
                    if ("-1".equals(custSearchForm.getSex())) {
                        predicates.add(cb.notEqual(root.get("sex"), custSearchForm.getSex()));
                    } else {
                        predicates.add(cb.equal(root.get("sex"), custSearchForm.getSex()));
                    }
                }
                if (custSearchForm.getSalesState() != null && !"".equals(custSearchForm.getSalesState())) {
                    if ("-1".equals(custSearchForm.getSalesState())) {
                        predicates.add(cb.notEqual(root.get("salesState"), custSearchForm.getSalesState()));
                    } else {
                        predicates.add(cb.equal(root.get("salesState"), custSearchForm.getSalesState()));
                    }
                }
                if (custSearchForm.getInfoOriginal() != null && !"".equals(custSearchForm.getInfoOriginal())) {
                    if ("-1".equals(custSearchForm.getInfoOriginal())) {
                        predicates.add(cb.notEqual(root.get("infoOriginal"), custSearchForm.getInfoOriginal()));
                    } else {
                        predicates.add(cb.equal(root.get("infoOriginal"), custSearchForm.getInfoOriginal()));
                    }
                }
                if (custSearchForm.getWhyBorrow() != null && !"".equals(custSearchForm.getWhyBorrow())) {
                    if ("-1".equals(custSearchForm.getWhyBorrow())) {
                        predicates.add(cb.notEqual(root.get("whyBorrow"), custSearchForm.getWhyBorrow()));
                    } else {
                        predicates.add(cb.equal(root.get("whyBorrow"), custSearchForm.getWhyBorrow()));
                    }
                }
                if (custSearchForm.getJob() != null && !"".equals(custSearchForm.getJob())) {
                    if ("-1".equals(custSearchForm.getJob())) {
                        predicates.add(cb.notEqual(root.get("job"), custSearchForm.getJob()));
                    } else {
                        predicates.add(cb.equal(root.get("job"), custSearchForm.getJob()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return custRepository.findAll(specification);
    }

    @Override
    public void save(Cust cust) {
        custRepository.save(cust);
    }

    @Override
    public Cust getCustById(long id) {
        return custRepository.findById(id);
    }

    @Override
    public void merge(Cust cust) {
        custRepository.save(cust);
    }
}