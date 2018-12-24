package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.*;
import com.bangnd.sales.form.AgentSearchForm;

import java.util.*;

import com.bangnd.sales.repository.AgentRepository;
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
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public List<Agent> getAgentList(AgentSearchForm agentSearchForm) {
        Specification specification = new Specification<Agent>() {
            @Override
            public Predicate toPredicate(Root<Agent> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (agentSearchForm.getName() != null && !"".equals(agentSearchForm.getName())) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + agentSearchForm.getName() + "%"));
                }
                if (agentSearchForm.getBusinessType() != null && !"".equals(agentSearchForm.getBusinessType())) {
                    if ("0".equals(agentSearchForm.getBusinessType())) {
                        predicates.add(cb.notEqual(root.get("businessType"), agentSearchForm.getBusinessType()));
                    } else {
                        predicates.add(cb.equal(root.get("businessType"), agentSearchForm.getBusinessType()));
                    }
                }
                if (agentSearchForm.getChannelType() != null && !"".equals(agentSearchForm.getChannelType())) {
                    if ("0".equals(agentSearchForm.getChannelType())) {
                        predicates.add(cb.notEqual(root.get("channelType"), agentSearchForm.getChannelType()));
                    } else {
                        predicates.add(cb.equal(root.get("channelType"), agentSearchForm.getChannelType()));
                    }
                }
                if (agentSearchForm.getCentiCode() != null && !"".equals(agentSearchForm.getCentiCode())) {
                    predicates.add(cb.like(root.get("centiCode").as(String.class), "%" + agentSearchForm.getCentiCode() + "%"));
                }
                if (agentSearchForm.getPhoneNO() != null && !"".equals(agentSearchForm.getPhoneNO())) {
                    predicates.add(cb.like(root.get("phoneNO").as(String.class), "%" + agentSearchForm.getPhoneNO() + "%"));
                }
                if (agentSearchForm.getCompanyName() != null && !"".equals(agentSearchForm.getCompanyName())) {
                    predicates.add(cb.like(root.get("companyName").as(String.class), "%" + agentSearchForm.getCompanyName() + "%"));
                }
                if (agentSearchForm.getUserName() != null && !"".equals(agentSearchForm.getUserName())) {
                    predicates.add(cb.like(root.get("userName").as(String.class), "%" + agentSearchForm.getUserName() + "%"));
                }
                if (agentSearchForm.getJobYears() != null && !"".equals(agentSearchForm.getJobYears())) {
                    predicates.add(cb.like(root.get("jobYears").as(String.class), "%" + agentSearchForm.getJobYears() + "%"));
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return agentRepository.findAll(specification);
    }

    @Override
    public void save(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public Agent getAgentById(long id) {
        return agentRepository.findById(id);
    }

    @Override
    public void merge(Agent agent) {
        agentRepository.save(agent);
    }
}