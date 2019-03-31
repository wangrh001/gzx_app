package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.repository.OrderRepository;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void save(Order order) {
        orderRepository.save(order);
    }


    public Page<Order> getOrderList(Integer pageNum, int size, List<Long> orderList, OrderSearchForm orderSearchForm) {
        Assert.notNull(orderSearchForm);
        Specification specification = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                setPredicate(root,predicates,orderSearchForm,cb);

                //状态只能显示该角色下可以查看的状态
                CriteriaBuilder.In<Long> in = cb.in(root.get("id"));
                for(Long id:orderList){
                    in.value(id);
                }
                predicates.add(in);

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Order> qyPage = this.orderRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public Page<Order> getAllOrderList(Integer pageNum, int size, OrderSearchForm orderSearchForm) {
        Assert.notNull(orderSearchForm);
        Specification specification = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                setPredicate(root,predicates,orderSearchForm,cb);

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Order> qyPage = this.orderRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public List<Order> findOrderBySalesId(long salesId, Date startDate, Date endDate) {
        return this.orderRepository.findAllBySalsesId(salesId,startDate,endDate);
    }

    private void setPredicate(Root<Order> root,List<Predicate> predicates,OrderSearchForm orderSearchForm,CriteriaBuilder cb){
        if (orderSearchForm.getApplicantName() != null && !"".equals(orderSearchForm.getApplicantName())) {
            System.out.println("applicantName=" + orderSearchForm.getApplicantName());
            predicates.add(cb.like(root.get("applicantName").as(String.class), "%" + orderSearchForm.getApplicantName() + "%"));
        }

        if (orderSearchForm.getOrderState() != null && !"".equals(orderSearchForm.getOrderState())) {
            System.out.println("orderState=" + orderSearchForm.getOrderState());
            if ("0".equals(orderSearchForm.getOrderState())) {
                predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
            } else {
                predicates.add(cb.equal(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
            }
        }else {
            predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(ConstantCfg.ORDER_STATE_127)));
        }

        predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
        if (orderSearchForm.getCellPhone() != null && !"".equals(orderSearchForm.getCellPhone())) {
            System.out.println("cellPhone=" + orderSearchForm.getCellPhone());
            predicates.add(cb.equal(root.get("cellPhone"), orderSearchForm.getCellPhone()));
        }
        if (orderSearchForm.getBusinessType() != null && !"".equals(orderSearchForm.getBusinessType())) {
            System.out.println("businessType=" + orderSearchForm.getBusinessType());
            if ("0".equals(orderSearchForm.getBusinessType())) {
                predicates.add(cb.notEqual(root.get("businessType"), orderSearchForm.getBusinessType()));
            } else {
                predicates.add(cb.equal(root.get("businessType"), orderSearchForm.getBusinessType()));
            }
        }

        if (!"".equals(orderSearchForm.getStartDate()) && !"".equals(orderSearchForm.getEndDate())
                && orderSearchForm.getStartDate() != null && orderSearchForm.getEndDate() != null) {
            System.out.println("start_time=" + orderSearchForm.getStartDate());
            System.out.println("end_time=" + orderSearchForm.getEndDate());
            Date startDate = null;
            Date endDate = null;
            Calendar c = Calendar.getInstance();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                startDate = sdf.parse(orderSearchForm.getStartDate());
                endDate = sdf.parse(orderSearchForm.getEndDate());
                c.setTime(endDate);
                c.add(Calendar.DAY_OF_MONTH, 1);
            } catch (Exception e) {
                e.getMessage();
            }
            predicates.add(cb.between(root.get("applyTime").as(Date.class), startDate, c.getTime()));
        }
    }

    @Override
    public Order findOrderById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id.longValue());
        order.setState(100);
        orderRepository.save(order);
    }

    @Override
    public void flush(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
