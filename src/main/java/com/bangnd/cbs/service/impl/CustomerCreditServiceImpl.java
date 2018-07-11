package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.CustomerCredit;
import com.bangnd.cbs.repository.CustomerCreditRepository;
import com.bangnd.cbs.service.CustomerCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreditServiceImpl implements CustomerCreditService {
    @Autowired
    CustomerCreditRepository customerCreditRepository;

    @Override
    public void save(CustomerCredit customerCredit){
        customerCreditRepository.save(customerCredit);
    }

    @Override
    public CustomerCredit findCustCreditById(long id) {
        return customerCreditRepository.findById(id);
    }
}
