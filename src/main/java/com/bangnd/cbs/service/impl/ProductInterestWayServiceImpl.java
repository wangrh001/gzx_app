package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInterestWayServiceImpl implements ProductInterestWayService {
    @Autowired
    private ProductInterestWayRepository productInterestWayRepository;

    @Override
    public List<ProductInterestWay> getAll() {
        return productInterestWayRepository.findAll();
    }

    @Override
    public ProductInterestWay getProductInterestWayById(int id) {
        return productInterestWayRepository.findOne(id);
    }
}