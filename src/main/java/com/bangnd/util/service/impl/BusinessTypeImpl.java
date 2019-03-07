package com.bangnd.util.service.impl;

import com.bangnd.util.repository.BusinessTypeReository;
import com.bangnd.util.service.BusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessTypeImpl implements BusinessTypeService {

    @Autowired
    BusinessTypeReository businessTypeReository;

    @Override
    public List<com.bangnd.util.entity.BusinessType> getAll() {
        return businessTypeReository.findAll();
    }
}
