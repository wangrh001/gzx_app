package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.CustomerCredit;

public interface CustomerCreditService {
    public void save(CustomerCredit customerCredit);
    public CustomerCredit findCustCreditById(long id);
}
