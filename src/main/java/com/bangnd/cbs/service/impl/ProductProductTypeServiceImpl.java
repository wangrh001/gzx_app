package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductProductTypeServiceImpl implements ProductProductTypeService {
    @Autowired
    private ProductProductTypeRepository productProductTypeRepository;

    @Override
    public List<ProductProductType> getAll() {
        return productProductTypeRepository.findAll();
    }

    @Override
    public ProductProductType getProductProductTypeById(int id) {
        return productProductTypeRepository.findOne(id);
    }
}