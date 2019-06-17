package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.OriginalLoanForeclosureType;

import java.util.List;

public interface OriginalLoanForeclosureTypeService {
    public List<OriginalLoanForeclosureType> getAll();

    public OriginalLoanForeclosureType getOneById(int id);
}
