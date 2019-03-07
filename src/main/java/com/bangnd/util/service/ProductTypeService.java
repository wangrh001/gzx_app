package com.bangnd.util.service;

import com.bangnd.util.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    public List<ProductType> getAll();

    public ProductType getObjById(long id);
}
