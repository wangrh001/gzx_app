package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.OriginalLoanBank;
import com.bangnd.bridgecbs.repository.OriginalLoanBankRepository;
import com.bangnd.bridgecbs.service.OriginalLoanBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OriginalLoanBankServiceImpl implements OriginalLoanBankService {
    @Autowired
    private OriginalLoanBankRepository originalLoanBankRepository;

    @Override
    public List<OriginalLoanBank> getAll() {
        return originalLoanBankRepository.findAll();
    }

    @Override
    public OriginalLoanBank getOneById(int id) {
        return originalLoanBankRepository.findOne(id);
    }
}
