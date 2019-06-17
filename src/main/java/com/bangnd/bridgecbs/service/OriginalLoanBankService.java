package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.OriginalLoanBank;

import java.util.List;

public interface OriginalLoanBankService {

    public List<OriginalLoanBank> getAll();

    public OriginalLoanBank getOneById(int id);
}
