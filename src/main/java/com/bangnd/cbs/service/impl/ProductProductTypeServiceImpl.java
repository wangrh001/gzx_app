package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.ProductProductType;
import com.bangnd.cbs.repository.ProductProductTypeRepository;
import com.bangnd.cbs.service.ProductProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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