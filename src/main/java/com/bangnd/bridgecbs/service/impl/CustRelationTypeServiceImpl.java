package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.CustRelationType;
import com.bangnd.bridgecbs.repository.CustRelationTypeRepository;
import com.bangnd.bridgecbs.service.CustRelationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustRelationTypeServiceImpl implements CustRelationTypeService {
    @Autowired
    private CustRelationTypeRepository custRelationTypeRespository;

    @Override
    public List<CustRelationType> getAll() {
        return custRelationTypeRespository.findAll();
    }

    @Override
    public CustRelationType getCustTypeById(int id) {
        return custRelationTypeRespository.findOne(id);
    }
}
