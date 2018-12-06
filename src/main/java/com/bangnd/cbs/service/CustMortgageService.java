package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.CustMortgage;

public interface CustMortgageService {
    public void save(CustMortgage mortgage);
    public CustMortgage findMortgageById(long id);
    public CustMortgage findMortgageByCustomerId(long id);
}
