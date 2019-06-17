package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.NewLoanCondition;
import com.bangnd.bridgecbs.repository.NewLoanConditionRepository;
import com.bangnd.bridgecbs.service.NewLoanConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewLoanConditionServiceImpl implements NewLoanConditionService {
    @Autowired
    private NewLoanConditionRepository newLoanConditionRepository;

    @Override
    public List<NewLoanCondition> getAll() {
        return newLoanConditionRepository.findAll();
    }

    @Override
    public NewLoanCondition getOneById(int id) {
        return newLoanConditionRepository.findOne(id);
    }
}
