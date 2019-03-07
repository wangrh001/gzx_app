package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.Job;
import com.bangnd.batch.service.*;
import com.bangnd.batch.form.JobSearchForm;

import java.util.*;

import com.bangnd.batch.repository.JobRepository;
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
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobList(JobSearchForm jobSearchForm) {
        Specification specification = new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (jobSearchForm.getBatchName() != null && !"".equals(jobSearchForm.getBatchName())) {
                    predicates.add(cb.like(root.get("batchName").as(String.class), "%" + jobSearchForm.getBatchName() + "%"));
                }
                if (jobSearchForm.getType() != null && !"".equals(jobSearchForm.getType())) {
                    if ("0".equals(jobSearchForm.getType())) {
                        predicates.add(cb.notEqual(root.get("type"), jobSearchForm.getType()));
                    } else {
                        predicates.add(cb.equal(root.get("type"), jobSearchForm.getType()));
                    }
                }
                if (jobSearchForm.getNextTimeStart() != null && !"".equals(jobSearchForm.getNextTimeStart()) && jobSearchForm.getNextTimeEnd() != null && !"".equals(jobSearchForm.getNextTimeEnd())) {
                    predicates.add(cb.between(root.get("nextTime").as(Date.class), jobSearchForm.getNextTimeStart(), jobSearchForm.getNextTimeEnd()));
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return jobRepository.findAll(specification);
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findById(id);
    }

    @Override
    public void merge(Job job) {
        jobRepository.save(job);
    }
}