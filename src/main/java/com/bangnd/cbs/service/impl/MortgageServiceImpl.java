package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Mortgage;
import com.bangnd.cbs.repository.MortgageRepository;
import com.bangnd.cbs.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageServiceImpl implements MortgageService {
    @Autowired
    MortgageRepository mortgageRepository;

    @Override
    public void save(Mortgage mortgage) {
        mortgageRepository.save(mortgage);
    }
}
