package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.NewLoanCondition;

import java.util.List;

public interface NewLoanConditionService {

    public List<NewLoanCondition> getAll();

    public NewLoanCondition getOneById(int id);
}
