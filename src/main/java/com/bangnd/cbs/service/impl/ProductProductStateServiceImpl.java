package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.ProductProductState;
import com.bangnd.cbs.repository.ProductProductStateRepository;
import com.bangnd.cbs.service.ProductProductStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductProductStateServiceImpl implements ProductProductStateService {
    @Autowired
    private ProductProductStateRepository productProductStateRepository;

    @Override
    public List<ProductProductState> getAll() {
        return productProductStateRepository.findAll();
    }

    @Override
    public ProductProductState getProductProductStateById(int id) {
        return productProductStateRepository.findOne(id);
    }
}