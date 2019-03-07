package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.CustCredit;

public interface CustCreditService {
    public void save(CustCredit customerCredit);

    public CustCredit findCustCreditById(long id);

    public CustCredit findCustCreditByCustomerId(long id);
}
