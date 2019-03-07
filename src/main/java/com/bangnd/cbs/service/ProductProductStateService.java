package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.*;

import java.util.List;

public interface ProductProductStateService {
    public List<ProductProductState> getAll();

    public ProductProductState getProductProductStateById(int id);
}