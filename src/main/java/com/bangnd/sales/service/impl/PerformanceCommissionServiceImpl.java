package com.bangnd.sales.service.impl;

import com.bangnd.cbs.service.OrderService;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;
import com.bangnd.sales.repository.PerformanceCommDetailRepository;
import com.bangnd.sales.repository.PerformanceCommissionRepository;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.util.date.DateUtil;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PerformanceCommissionServiceImpl implements PerformanceCommissionService {
    @Autowired
    private PerformanceCommissionRepository performanceCommissionRepository;
    @Autowired
    private PerformanceCommDetailRepository performanceCommDetailRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AgentService agentService;

    public Page<PerformanceCommission> getPerformanceCommissionList(Integer pageNum, int size, PerformanceCommissionSearchForm performanceCommissionSearchForm) {
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
                if (performanceCommissionSearchForm.getEmployeeName() != null && !"".equals(performanceCommissionSearchForm.getEmployeeName())) {
                    predicates.add(cb.like(root.get("employeeName").as(String.class), "%" + performanceCommissionSearchForm.getEmployeeName() + "%"));
                }
                if (performanceCommissionSearchForm.getProcess() != null && !"".equals(performanceCommissionSearchForm.getProcess())) {
                    if ("-1".equals(performanceCommissionSearchForm.getProcess())) {
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
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<PerformanceCommission> qyPage = this.performanceCommissionRepository.findAll(specification, pageable);
        return qyPage;
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

    @Override
    public void calcMonthCommission(long agentId, Date signDate) {
        Date startDate = DateUtil.getMonthStart(signDate);
        Date endDate = DateUtil.getMonthEnd(signDate);
        String yearMonth = DateUtil.getYearMonth(signDate);
        BigDecimal performance = new BigDecimal(0.0);
        BigDecimal interest = new BigDecimal(0.0);
        BigDecimal minCommission = new BigDecimal(0.0);
        BigDecimal maxCommission = new BigDecimal(0.0);
        BigDecimal commission = new BigDecimal(0.0);

        PerformanceCommission pc = performanceCommissionRepository.findByMonthAndSalerId(yearMonth, agentId);
        List<PerformanceCommDetail> pcs = performanceCommDetailRepository.findAllByAgentId(agentId, startDate, endDate);
        if (pcs != null && pcs.size() > 0) {
            for (PerformanceCommDetail performanceCommDetail : pcs) {
                //PerformanceCommDetail performanceCommDetail = performanceCommDetailRepository.findPerformanceCommDetailByOrderId(order.getId(), agentId);
                performance = performance.add(performanceCommDetail.getPerformance());
                interest = interest.add(performanceCommDetail.getInterest());
                minCommission = minCommission.add(performanceCommDetail.getMinCommission());
                maxCommission = maxCommission.add(performanceCommDetail.getMaxCommission());
                commission = commission.add(performanceCommDetail.getCommission());
            }
        }
        if (pc != null && !"".equals(pc.getMonth()) && pc.getMonth() != null) {
            pc.setPerformance(performance);
            pc.setInterest(interest);
            pc.setCommission(commission);
            pc.setMinCommission(minCommission);
            pc.setMaxCommission(maxCommission);
            pc.setUpdateTime(new Date());
            performanceCommissionRepository.save(pc);
        } else {
            pc = new PerformanceCommission();
            pc.setCreateTime(new Date());
            pc.setCreator(0);
            pc.setState(1);
            pc.setMonth(yearMonth);
            pc.setSalerId(agentId);
            pc.setProcess(1);
            pc.setSalerName(agentService.getAgentById(agentId).getName());
            pc.setPerformance(performance);
            pc.setInterest(interest);
            pc.setCommission(commission);
            pc.setMinCommission(minCommission);
            pc.setMaxCommission(maxCommission);
            performanceCommissionRepository.save(pc);
        }
    }
    @Override
    public PerformanceCommission getPerformanceCommissionByAgentIdAndMonth(long agentId, String month) {
        return performanceCommissionRepository.findAllByAgentIdAndMonth(agentId,month);
    }
}