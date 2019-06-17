package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.CustCertiType;
import com.bangnd.bridgecbs.repository.CustCertiTypeRepository;
import com.bangnd.bridgecbs.service.CustCertiTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustCertiTypeServiceImpl implements CustCertiTypeService {
    @Autowired
    private CustCertiTypeRepository custCertiTypeRespository;

    @Override
    public List<CustCertiType> getAll() {
        return custCertiTypeRespository.findAll();
    }

    @Override
    public CustCertiType getCertiTypeById(int id) {
        return custCertiTypeRespository.findOne(id);
    }
}
