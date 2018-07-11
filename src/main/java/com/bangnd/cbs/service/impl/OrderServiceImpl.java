package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.repository.OrderRepository;
import com.bangnd.cbs.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void save(Order order){
        orderRepository.save(order);
    }


    public List<Order> getOrderList(OrderSearchForm orderSearchForm) {
        Assert.notNull(orderSearchForm);
        Specification specification = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (orderSearchForm.getName()!=null && !"".equals(orderSearchForm.getName())) {
                    predicates.add(cb.like(root.get("borrowerName").as(String.class), "%" + orderSearchForm.getName() + "%"));
                }

                if (orderSearchForm.getType() != null) {
                    if("0".equals(orderSearchForm.getType())){
                        System.out.println("enter the type = 0");
                        predicates.add(cb.notEqual(root.get("productType").as(Long.class), new Long(orderSearchForm.getType())));
                    }else {
                        System.out.println("enter the type != 0");
                        predicates.add(cb.equal(root.get("productType").as(Long.class), new Long(orderSearchForm.getType())));
                    }
                }

                if (orderSearchForm.getOrderState()!=null) {
                    if("0".equals(orderSearchForm.getOrderState())){
                        System.out.println("enter the orderState = 0");
                        predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
                    }else {
                        System.out.println("enter the orderState != 0");
                        predicates.add(cb.equal(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
                    }
                }
                if (orderSearchForm.getStartDate() != null && orderSearchForm.getEndDate() != null) {
                    Date startDate=null;
                    Date endDate=null;
                    try {
                        SimpleDateFormat sdf =   new SimpleDateFormat("MM/dd/yyyy");
                        System.out.println("start_time="+orderSearchForm.getStartDate());
                        System.out.println("end_time="+orderSearchForm.getEndDate());
                        startDate = sdf.parse(orderSearchForm.getStartDate());
                        endDate = sdf.parse(orderSearchForm.getEndDate());

                    }catch (Exception e){
                        e.getMessage();
                    }
                    predicates.add(cb.between(root.get("applyTime").as(Date.class),startDate,endDate));
                }

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return orderRepository.findAll(specification);
    }
    @Override
    public Order findOrderById(long id){
        return orderRepository.findByOrderId(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteByIds(id);
    }
}
