package com.bangnd.crm.service;

import com.bangnd.crm.entity.*;

import java.util.List;

public interface CustWhyBorrowService {
    public List<CustWhyBorrow> getAll();

    public CustWhyBorrow getCustWhyBorrowById(int id);
}