package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustWhyBorrow;
import com.bangnd.crm.repository.CustWhyBorrowRepository;
import com.bangnd.crm.service.CustWhyBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustWhyBorrowServiceImpl implements CustWhyBorrowService {
    @Autowired
    private CustWhyBorrowRepository custWhyBorrowRepository;

    @Override
    public List<CustWhyBorrow> getAll() {
        return custWhyBorrowRepository.findAll();
    }

    @Override
    public CustWhyBorrow getCustWhyBorrowById(int id) {
        return custWhyBorrowRepository.findOne(id);
    }
}