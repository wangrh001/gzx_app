package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.entity.OrderProdCustRelation;
import com.bangnd.cbs.repository.OrderProdCustRelationRepository;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.cbs.service.OrderProdCustRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProdCustRelationServiceImpl implements OrderProdCustRelationService {
    @Autowired
    OrderProdCustRelationRepository orderProdCustRelationRepository;

    @Resource
    CustomerService customerService;

    @Override
    public void save(OrderProdCustRelation orderProdCustRelation) {
        orderProdCustRelationRepository.save(orderProdCustRelation);
    }

    @Override
    public List<Customer> findCustomersByOrderId(long orderId) {
        List<OrderProdCustRelation> orderProdCustRelations = orderProdCustRelationRepository.findAllByOrderId(orderId);
        List<Customer> customers = new ArrayList<Customer>();
        if (orderProdCustRelations != null) {
            for (OrderProdCustRelation orderProdCustRelation : orderProdCustRelations) {
                Customer customer = customerService.findCustomerById(orderProdCustRelation.getCustomerId());
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public Customer findCustomerByOrderProductId(long orderProductId, long identityType) {
        System.out.println("orderProdctId=" + orderProductId);
        System.out.println("identityType=" + identityType);
        OrderProdCustRelation orderProdCustRelation = orderProdCustRelationRepository.findByOrderProductId(orderProductId, identityType);
        Customer customer = new Customer();
        if (orderProdCustRelation != null) {
            customer = customerService.findCustomerById(orderProdCustRelation.getCustomerId());
        }
        return customer;
    }

    @Override
    public List<OrderProdCustRelation> getObjsByOrderProdId(long id) {
        return orderProdCustRelationRepository.findAllByOrderProductId(id);
    }

    @Override
    public OrderProdCustRelation findObjByOrderProductId(long orderProductId, long identityType) {
        return orderProdCustRelationRepository.findByOrderProductId(orderProductId, identityType);
    }
}
