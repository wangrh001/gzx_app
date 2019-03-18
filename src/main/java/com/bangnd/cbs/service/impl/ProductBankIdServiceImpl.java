package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.ProductBankId;
import com.bangnd.cbs.repository.ProductBankIdRepository;
import com.bangnd.cbs.service.ProductBankIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBankIdServiceImpl implements ProductBankIdService {
    @Autowired
    private ProductBankIdRepository productBankIdRepository;

    @Override
    public List<ProductBankId> getAll() {
        return productBankIdRepository.findAll();
    }

    @Override
    public ProductBankId getProductBankIdById(int id) {
        return productBankIdRepository.findOne(id);
    }
}