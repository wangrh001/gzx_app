package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.Knowledge;
import com.bangnd.cs.form.KnowledgeSearchForm;
import com.bangnd.cs.repository.KnowledgeRepository;
import com.bangnd.cs.service.KnowledgeService;
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
public class KnowledgeServiceImpl implements KnowledgeService {
    @Autowired
    private KnowledgeRepository knowledgeRepository;

    public List<Knowledge> getKnowledgeList(KnowledgeSearchForm knowledgeSearchForm) {
        Specification specification = new Specification<Knowledge>() {
            @Override
            public Predicate toPredicate(Root<Knowledge> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (knowledgeSearchForm.getQuestionName() != null && !"".equals(knowledgeSearchForm.getQuestionName())) {
                    predicates.add(cb.like(root.get("questionName").as(String.class), "%" + knowledgeSearchForm.getQuestionName() + "%"));
                }
                if (knowledgeSearchForm.getQuestion() != null && !"".equals(knowledgeSearchForm.getQuestion())) {
                    predicates.add(cb.like(root.get("question").as(String.class), "%" + knowledgeSearchForm.getQuestion() + "%"));
                }
                if (knowledgeSearchForm.getQuestionType() != null && !"".equals(knowledgeSearchForm.getQuestionType())) {
                    if ("0".equals(knowledgeSearchForm.getQuestionType())) {
                        predicates.add(cb.notEqual(root.get("questionType"), knowledgeSearchForm.getQuestionType()));
                    } else {
                        predicates.add(cb.equal(root.get("questionType"), knowledgeSearchForm.getQuestionType()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return knowledgeRepository.findAll(specification);
    }

    @Override
    public void save(Knowledge knowledge) {
        knowledgeRepository.save(knowledge);
    }

    @Override
    public Knowledge getKnowledgeById(long id) {
        return knowledgeRepository.findById(id);
    }

    @Override
    public void merge(Knowledge knowledge) {
        knowledgeRepository.save(knowledge);
    }
}