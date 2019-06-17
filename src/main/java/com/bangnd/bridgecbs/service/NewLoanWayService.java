package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.NewLoanWay;

import java.util.List;

public interface NewLoanWayService {
    public List<NewLoanWay> getAll();

    public NewLoanWay getOneById(int id);
}
