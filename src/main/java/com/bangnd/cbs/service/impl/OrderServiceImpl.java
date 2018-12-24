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
import java.util.Calendar;
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

                if (orderSearchForm.getApplicantName()!=null && !"".equals(orderSearchForm.getApplicantName())) {
                    System.out.println("applicantName="+orderSearchForm.getApplicantName());
                    predicates.add(cb.like(root.get("applicantName").as(String.class), "%" + orderSearchForm.getApplicantName() + "%"));
                }

//                if (orderSearchForm.getType() != null) {
//                    if("0".equals(orderSearchForm.getType())){
//                        System.out.println("enter the type = 0");
//                        predicates.add(cb.notEqual(root.get("productType").as(Long.class), new Long(orderSearchForm.getType())));
//                    }else {
//                        System.out.println("enter the type != 0");
//                        predicates.add(cb.equal(root.get("productType").as(Long.class), new Long(orderSearchForm.getType())));
//                    }
//                }

                if (orderSearchForm.getOrderState()!=null && !"".equals(orderSearchForm.getOrderState())) {
                    System.out.println("orderState="+orderSearchForm.getOrderState());
                    if("0".equals(orderSearchForm.getOrderState())){
                        System.out.println("enter the orderState = 0");
                        predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
                    }else {
                        System.out.println("enter the orderState != 0");
                        predicates.add(cb.equal(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
                    }
                }
                predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(100)));
                if (orderSearchForm.getCellPhone()!=null && !"".equals(orderSearchForm.getCellPhone())) {
                    System.out.println("cellPhone="+orderSearchForm.getCellPhone());
                    predicates.add(cb.equal(root.get("cellPhone"), orderSearchForm.getCellPhone()));
                }

                if (orderSearchForm.getBusinessType()!=null && !"".equals(orderSearchForm.getBusinessType())) {
                    System.out.println("businessType="+orderSearchForm.getBusinessType());
                    if("0".equals(orderSearchForm.getBusinessType())){
                        predicates.add(cb.notEqual(root.get("businessType"), orderSearchForm.getBusinessType()));
                    }else {
                        predicates.add(cb.equal(root.get("businessType"), orderSearchForm.getBusinessType()));
                    }
                }

                if ( !"".equals(orderSearchForm.getStartDate()) && !"".equals(orderSearchForm.getEndDate())
                        &&orderSearchForm.getStartDate()!=null && orderSearchForm.getEndDate() !=null) {
                    System.out.println("start_time="+orderSearchForm.getStartDate());
                    System.out.println("end_time="+orderSearchForm.getEndDate());
                    Date startDate=null;
                    Date endDate=null;
                    Calendar c = Calendar.getInstance();
                    try {
                        SimpleDateFormat sdf =   new SimpleDateFormat("MM/dd/yyyy");
                        startDate = sdf.parse(orderSearchForm.getStartDate());
                        endDate = sdf.parse(orderSearchForm.getEndDate());
                        c.setTime(endDate);
                        c.add(Calendar.DAY_OF_MONTH,1);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    predicates.add(cb.between(root.get("applyTime").as(Date.class),startDate,c.getTime()));
                }

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return orderRepository.findAll(specification);
    }
    @Override
    public Order findOrderById(long id){
        return orderRepository.findById(id);
    }

    public void update(Order order){
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id.longValue());
        order.setOrderState(100);
        orderRepository.save(order);
    }

    @Override
    public void flush(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
