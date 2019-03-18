package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.ProductInterestWay;

import java.util.List;

public interface ProductInterestWayService {
    public List<ProductInterestWay> getAll();

    public ProductInterestWay getProductInterestWayById(int id);
}