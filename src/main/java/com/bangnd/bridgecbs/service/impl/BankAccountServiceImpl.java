package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BankAccount;
import com.bangnd.bridgecbs.repository.BankAccountRepository;
import com.bangnd.bridgecbs.service.BankAccountService;
import com.bangnd.bridgecbs.service.BridgeOrderAcceptionBankCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BridgeOrderAcceptionBankCodeService bridgeOrderAcceptionBankCodeService;

    @Override
    public void save(BankAccount bankAccount, Long orderId,Long newLoanId) {
        bankAccount.setBankIdName(bridgeOrderAcceptionBankCodeService.getBridgeOrderAcceptionBankCodeById(bankAccount.getBankId()).getName());
        bankAccount.setOrderId(orderId);
        if(newLoanId!=null && !"".equals(newLoanId)){
            bankAccount.setNewLoanId(newLoanId);
        }
        bankAccount.setState(1);
        bankAccount.setCreateTime(new Date());
        bankAccount.setCreator(0);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getAllByOrderIdAndType(Long orderId, int type) {
        return bankAccountRepository.findAllByOrderIdAndType(orderId,type);
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findBankAccountById(id);
    }

    @Override
    public void merge(BankAccount bankAccount) {
        bankAccountRepository.saveAndFlush(bankAccount);
    }
}
