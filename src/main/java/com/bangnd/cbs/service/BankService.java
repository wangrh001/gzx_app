package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BankService {
    public List<Bank> getAll();
}
