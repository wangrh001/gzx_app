package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.entity.OrderProdCustRelation;

import java.util.List;

public interface OrderProdCustRelationService {
    public void save(OrderProdCustRelation orderProdCustRelation);
    public List<Customer> findCustomersByOrderId(long orderId);
    public Customer findCustomerByOrderProductId(long orderProductId,long identityType);

}
