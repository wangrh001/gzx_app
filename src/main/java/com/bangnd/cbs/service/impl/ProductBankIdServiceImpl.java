package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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