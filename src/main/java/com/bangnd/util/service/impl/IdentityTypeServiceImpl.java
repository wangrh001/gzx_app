package com.bangnd.util.service.impl;

import com.bangnd.util.entity.IdentityType;
import com.bangnd.util.repository.IdentityTypeRepository;
import com.bangnd.util.service.IdentityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityTypeServiceImpl implements IdentityTypeService {
    @Autowired
    IdentityTypeRepository identityTypeRepository;

    @Override
    public List<IdentityType> getAll() {
        return identityTypeRepository.findAll();
    }
}
