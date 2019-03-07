package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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