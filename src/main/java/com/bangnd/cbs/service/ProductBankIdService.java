package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.ProductBankId;

import java.util.List;

public interface ProductBankIdService {
    public List<ProductBankId> getAll();

    public ProductBankId getProductBankIdById(int id);
}