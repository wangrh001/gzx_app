package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.OriginalLoanOrganType;
import com.bangnd.bridgecbs.repository.OriginalLoanOrganTypeRepository;
import com.bangnd.bridgecbs.service.OriginalLoanOrganTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OriginalLoanOrganTypeServiceImpl implements OriginalLoanOrganTypeService {

    @Autowired
    private OriginalLoanOrganTypeRepository originalLoanOrganTypeRepository;

    @Override
    public List<OriginalLoanOrganType> getAll() {
        return originalLoanOrganTypeRepository.findAll();
    }

    @Override
    public OriginalLoanOrganType getOneById(int id) {
        return originalLoanOrganTypeRepository.findOne(id);
    }
}
