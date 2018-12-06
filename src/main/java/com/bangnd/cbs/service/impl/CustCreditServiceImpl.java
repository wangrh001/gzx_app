package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.CustCredit;
import com.bangnd.cbs.repository.CustCreditRepository;
import com.bangnd.cbs.service.CustCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustCreditServiceImpl implements CustCreditService {
    @Autowired
    CustCreditRepository custCreditRepository;

    @Override
    public void save(CustCredit custCredit){
        custCreditRepository.save(custCredit);
    }

    @Override
    public CustCredit findCustCreditById(long id) {
        return custCreditRepository.findById(id);
    }

    @Override
    public CustCredit findCustCreditByCustomerId(long id) {
        return custCreditRepository.findCustCreditByCustomerId(id);
    }
}
