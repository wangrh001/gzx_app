package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    public void save(BankAccount bankAccount,Long orderId,Long newLoanId);
    public List<BankAccount> getAllByOrderIdAndType(Long orderId,int type);
    public BankAccount getBankAccountById(Long id);
    public void merge(BankAccount bankAccount);
}
