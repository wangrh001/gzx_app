package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.CustMortgage;
import com.bangnd.cbs.repository.CustMortgageRepository;
import com.bangnd.cbs.service.CustMortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustMortgageServiceImpl implements CustMortgageService {
    @Autowired
    CustMortgageRepository custMortgageRepository;

    @Override
    public void save(CustMortgage mortgage) {
        custMortgageRepository.save(mortgage);
    }

    @Override
    public CustMortgage findMortgageById(long id) {
        return custMortgageRepository.findByMortgageId(id);
    }

    @Override
    public CustMortgage findMortgageByCustomerId(long id) {
        return custMortgageRepository.findMortgageByCustomerId(id);
    }
}
