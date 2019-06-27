package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeCustomer;
import com.bangnd.bridgecbs.repository.BridgeCustomerRepository;
import com.bangnd.bridgecbs.service.CustCertiTypeService;
import com.bangnd.bridgecbs.service.CustRelationTypeService;
import com.bangnd.bridgecbs.service.CustomerService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BridgeCustomerServiceImpl implements CustomerService {

    @Autowired
    private BridgeCustomerRepository bridgeCustomerRepository;

    @Autowired
    private CustRelationTypeService custRelationTypeService;

    @Autowired
    private CustCertiTypeService custCertiTypeService;

    @Override
    public void save(BridgeCustomer customer, Long orderId, Long mortgageId) {
        customer.setOrderId(orderId);
        customer.setCustTypeName(custRelationTypeService.getCustTypeById(customer.getCustType()).getName());
        customer.setCertiTypeName(custCertiTypeService.getCertiTypeById(customer.getCertiType()).getName());
        //如果是产权人，需要修改类型
        if (mortgageId != null && !"".equals(mortgageId)) {
            customer.setMortgageId(mortgageId);
            customer.setCustType(ConstantCfg.CUST_RELATION_PROPERTY);
        }
        customer.setCustState(1);
        customer.setCreateTime(new Date());
        customer.setState(1);
        bridgeCustomerRepository.save(customer);
    }

    @Override
    public List<BridgeCustomer> getAllByOrderId(Long orderId) {
        return bridgeCustomerRepository.findAllByOrderId(orderId);
    }

    @Override
    public List<BridgeCustomer> getAllByOrderMortgageId(Long mortgageId) {
        return bridgeCustomerRepository.finAllByMortgageId(mortgageId);
    }

    @Override
    public BridgeCustomer getCustomerById(Long id) {
        return bridgeCustomerRepository.findOneById(id);
    }

    @Override
    public void merge(BridgeCustomer bridgeCustomer) {
        bridgeCustomerRepository.saveAndFlush(bridgeCustomer);
    }
}
