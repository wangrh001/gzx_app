package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.OriginalLoanOrganType;

import java.util.List;

public interface OriginalLoanOrganTypeService {

    public List<OriginalLoanOrganType> getAll();

    public OriginalLoanOrganType getOneById(int id);
}
