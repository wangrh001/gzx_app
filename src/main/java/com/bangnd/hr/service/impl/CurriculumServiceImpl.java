package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.Curriculum;
import com.bangnd.hr.form.CurriculumSearchForm;
import com.bangnd.hr.repository.CurriculumRepository;
import com.bangnd.hr.service.CurriculumService;
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
public class CurriculumServiceImpl implements CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public Page<Curriculum> getCurriculumList(Integer pageNum, int size, CurriculumSearchForm curriculumSearchForm) {
        Specification specification = new Specification<Curriculum>() {
            @Override
            public Predicate toPredicate(Root<Curriculum> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (curriculumSearchForm.getName() != null && !"".equals(curriculumSearchForm.getName())) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + curriculumSearchForm.getName() + "%"));
                }
                if (curriculumSearchForm.getType() != null && !"".equals(curriculumSearchForm.getType())) {
                    if ("-1".equals(curriculumSearchForm.getType())) {
                        predicates.add(cb.notEqual(root.get("type"), curriculumSearchForm.getType()));
                    } else {
                        predicates.add(cb.equal(root.get("type"), curriculumSearchForm.getType()));
                    }
                }
                if (curriculumSearchForm.getTeacherName() != null && !"".equals(curriculumSearchForm.getTeacherName())) {
                    predicates.add(cb.like(root.get("teacherName").as(String.class), "%" + curriculumSearchForm.getTeacherName() + "%"));
                }
                if (curriculumSearchForm.getPosId() != null && !"".equals(curriculumSearchForm.getPosId())) {
                    if ("-1".equals(curriculumSearchForm.getPosId())) {
                        predicates.add(cb.notEqual(root.get("posId"), curriculumSearchForm.getPosId()));
                    } else {
                        predicates.add(cb.equal(root.get("posId"), curriculumSearchForm.getPosId()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Curriculum> qyPage = this.curriculumRepository.findAll(specification, pageable);
        return qyPage;

    }

    @Override
    public void save(Curriculum curriculum) {
        curriculumRepository.save(curriculum);
    }

    @Override
    public Curriculum getCurriculumById(long id) {
        return curriculumRepository.findById(id);
    }

    @Override
    public void merge(Curriculum curriculum) {
        curriculumRepository.save(curriculum);
    }
}