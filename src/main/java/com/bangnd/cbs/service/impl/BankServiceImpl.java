package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Bank;
import com.bangnd.cbs.repository.BankRepository;
import com.bangnd.cbs.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    public BankRepository bankRepository;

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }
}
