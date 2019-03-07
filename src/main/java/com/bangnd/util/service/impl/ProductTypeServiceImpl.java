package com.bangnd.util.service.impl;

import com.bangnd.util.entity.ProductType;
import com.bangnd.util.repository.ProductTypeRepository;
import com.bangnd.util.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getObjById(long id) {
        return productTypeRepository.getOne(id);
    }
}
