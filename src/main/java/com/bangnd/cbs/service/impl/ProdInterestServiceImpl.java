package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.ProdInterest;
import com.bangnd.cbs.form.ProdInterestSearchForm;
import com.bangnd.cbs.repository.ProdInterestRepository;
import com.bangnd.cbs.service.ProdInterestService;
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
public class ProdInterestServiceImpl implements ProdInterestService {
    @Autowired
    private ProdInterestRepository prodInterestRepository;

    public Page<ProdInterest> getProdInterestList(Integer pageNum, int size, ProdInterestSearchForm prodInterestSearchForm) {
        Specification specification = new Specification<ProdInterest>() {
            @Override
            public Predicate toPredicate(Root<ProdInterest> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (prodInterestSearchForm.getPeriodType() != null && !"".equals(prodInterestSearchForm.getPeriodType())) {
                    if ("-1".equals(prodInterestSearchForm.getPeriodType())) {
                        predicates.add(cb.notEqual(root.get("periodType"), prodInterestSearchForm.getPeriodType()));
                    } else {
                        predicates.add(cb.equal(root.get("periodType"), prodInterestSearchForm.getPeriodType()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<ProdInterest> qyPage = this.prodInterestRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public void save(ProdInterest prodInterest) {
        prodInterestRepository.save(prodInterest);
    }

    @Override
    public ProdInterest getProdInterestById(long id) {
        return prodInterestRepository.findById(id);
    }

    @Override
    public void merge(ProdInterest prodInterest) {
        prodInterestRepository.save(prodInterest);
    }
}