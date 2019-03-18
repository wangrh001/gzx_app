package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.BTask;
import com.bangnd.batch.form.BTaskSearchForm;
import com.bangnd.batch.repository.BTaskRepository;
import com.bangnd.batch.service.BTaskService;
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
public class BTaskServiceImpl implements BTaskService {
    @Autowired
    private BTaskRepository BTaskRepository;

    public List<BTask> getBTaskList(BTaskSearchForm BTaskSearchForm) {
        Specification specification = new Specification<BTask>() {
            @Override
            public Predicate toPredicate(Root<BTask> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (BTaskSearchForm.getBatchName() != null && !"".equals(BTaskSearchForm.getBatchName())) {
                    predicates.add(cb.like(root.get("batchName").as(String.class), "%" + BTaskSearchForm.getBatchName() + "%"));
                }
                if (BTaskSearchForm.getResult() != null && !"".equals(BTaskSearchForm.getResult())) {
                    if ("0".equals(BTaskSearchForm.getResult())) {
                        predicates.add(cb.notEqual(root.get("result"), BTaskSearchForm.getResult()));
                    } else {
                        predicates.add(cb.equal(root.get("result"), BTaskSearchForm.getResult()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return BTaskRepository.findAll(specification);
    }

    @Override
    public void save(BTask BTask) {
        BTaskRepository.save(BTask);
    }

    @Override
    public BTask getBTaskById(long id) {
        return BTaskRepository.findById(id);
    }

    @Override
    public void merge(BTask BTask) {
        BTaskRepository.save(BTask);
    }
}