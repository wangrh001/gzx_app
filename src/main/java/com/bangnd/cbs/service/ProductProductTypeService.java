package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.*;

import java.util.List;

public interface ProductProductTypeService {
    public List<ProductProductType> getAll();

    public ProductProductType getProductProductTypeById(int id);
}