package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.ProductInterestWay;
import com.bangnd.cbs.repository.ProductInterestWayRepository;
import com.bangnd.cbs.service.ProductInterestWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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