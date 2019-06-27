package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.CustRelationType;

import java.util.List;

public interface CustRelationTypeService {
    public List<CustRelationType> getAll();

    public CustRelationType getCustTypeById(int id);
}
