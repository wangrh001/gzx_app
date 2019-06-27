package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.OriginalLoanForeclosureType;
import com.bangnd.bridgecbs.repository.OriginalLoanForeclosureTypeRepository;
import com.bangnd.bridgecbs.service.OriginalLoanForeclosureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginalLoanForeclosureTypeServiceImpl implements OriginalLoanForeclosureTypeService {
    @Autowired
    private OriginalLoanForeclosureTypeRepository originalLoanForeclosureTypeRepository;

    @Override
    public List<OriginalLoanForeclosureType> getAll() {
        return originalLoanForeclosureTypeRepository.findAll();
    }

    @Override
    public OriginalLoanForeclosureType getOneById(int id) {
        return originalLoanForeclosureTypeRepository.findOne(id);
    }
}
