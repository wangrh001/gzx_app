package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.MortgagePropertyState;
import com.bangnd.bridgecbs.repository.MortgagePropertyStateRepository;
import com.bangnd.bridgecbs.service.MortgagePropertyStatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgagePropertyStatesServiceImpl implements MortgagePropertyStatesService {
    @Autowired
    MortgagePropertyStateRepository mortgagePropertyStateRepository;

    @Override
    public List<MortgagePropertyState> getAll() {
        return mortgagePropertyStateRepository.findAll();
    }
}
