package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.OriginalLoanType;

import java.util.List;

public interface OriginalLoanTypeService {
    public List<OriginalLoanType> getAll();

    public OriginalLoanType getOneById(int id);
}
