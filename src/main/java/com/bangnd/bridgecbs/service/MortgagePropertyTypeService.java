package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.MortgagePropertyType;

import java.util.List;

public interface MortgagePropertyTypeService {
    public List<MortgagePropertyType> getAll();
    public MortgagePropertyType getOneById(int id);
}
