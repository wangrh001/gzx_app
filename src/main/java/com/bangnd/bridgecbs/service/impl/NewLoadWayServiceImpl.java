package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.NewLoanWay;
import com.bangnd.bridgecbs.repository.NewLoanWayRepository;
import com.bangnd.bridgecbs.service.NewLoanWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewLoadWayServiceImpl implements NewLoanWayService {
    @Autowired
    private NewLoanWayRepository newLoanWayRepository;

    @Override
    public List<NewLoanWay> getAll() {
        return newLoanWayRepository.findAll();
    }

    @Override
    public NewLoanWay getOneById(int id) {
        return newLoanWayRepository.findOne(id);
    }
}
