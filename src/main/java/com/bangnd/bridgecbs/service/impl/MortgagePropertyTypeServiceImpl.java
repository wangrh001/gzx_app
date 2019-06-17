package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.MortgagePropertyType;
import com.bangnd.bridgecbs.repository.MortgagePropertyTypeRepository;
import com.bangnd.bridgecbs.service.MortgagePropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MortgagePropertyTypeServiceImpl implements MortgagePropertyTypeService {
    @Autowired
    private MortgagePropertyTypeRepository mortgagePropertyTypeRepository;

    @Override
    public List<MortgagePropertyType> getAll() {
        return mortgagePropertyTypeRepository.findAll();
    }

    @Override
    public MortgagePropertyType getOneById(int id) {
        return mortgagePropertyTypeRepository.findOne(id);
    }
}
