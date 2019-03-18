package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.entity.OrderLog;
import com.bangnd.cbs.repository.OrderLogRepository;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.util.cfg.ConstantCfg;
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
import java.util.Date;
import java.util.List;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Autowired
    OrderLogRepository orderLogRepository;

    @Override
    public void save(OrderLog orderLog) {
        orderLogRepository.save(orderLog);
    }

    @Override
    public Page<OrderLog> getAllLogByOrderId(Integer pageNum, int size, long orderId) {
        Specification specification = new Specification<OrderLog>() {
            @Override
            public Predicate toPredicate(Root<OrderLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(cb.equal(root.get("orderId").as(Long.class),orderId));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<OrderLog> qyPage = this.orderLogRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public boolean isHandleOrder(long orderId, long userId) {
        List<OrderLog> orderLogs = orderLogRepository.findAllByOrderIdAndUserId(orderId,userId);
        if(orderLogs!=null){
            return true;
        }else return false;
    }
    @Override
    public void recordLog(long orderId,long userId,int actionId){
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(orderId);
        orderLog.setUserId(userId);
        orderLog.setActionId(actionId);
        orderLog.setState(1);
        orderLog.setCreator(Long.valueOf(userId).intValue());
        orderLog.setCreateTime(new Date());
        orderLogRepository.save(orderLog);
    }
}
