package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.BridgeCustomer;

import java.util.List;

public interface CustomerService {
    public void save(BridgeCustomer customer, Long orderId, Long mortgageId);
    public List<BridgeCustomer> getAllByOrderId(Long orderId);
    public List<BridgeCustomer> getAllByOrderMortgageId(Long mortgageId);
    public BridgeCustomer getCustomerById(Long id);
    public void merge(BridgeCustomer bridgeCustomer);

}
