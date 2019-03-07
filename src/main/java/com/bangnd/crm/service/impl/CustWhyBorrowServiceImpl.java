package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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