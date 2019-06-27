package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.OriginalLoanType;
import com.bangnd.bridgecbs.repository.OriginalLoanTypeRepository;
import com.bangnd.bridgecbs.service.OriginalLoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginalLoanTypeServiceImpl implements OriginalLoanTypeService {

    @Autowired
    private OriginalLoanTypeRepository originalLoanTypeRepository;

    @Override
    public List<OriginalLoanType> getAll() {
        return originalLoanTypeRepository.findAll();
    }

    @Override
    public OriginalLoanType getOneById(int id) {
        return originalLoanTypeRepository.findOne(id);
    }
}
