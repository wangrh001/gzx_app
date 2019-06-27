package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.MortgageEstateType;
import com.bangnd.bridgecbs.repository.MortgageEstateTypeRepository;
import com.bangnd.bridgecbs.service.MortgageEstateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageEstateTypeServiceImpl implements MortgageEstateTypeService {

    @Autowired
    private MortgageEstateTypeRepository mortgageEstateTypeRepository;

    @Override
    public List<MortgageEstateType> getAll() {
        return mortgageEstateTypeRepository.findAll();
    }
}
