package com.bangnd.util.service.impl;

import com.bangnd.util.entity.PeriodType;
import com.bangnd.util.repository.PeriodTypeRepository;
import com.bangnd.util.service.PeriodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodTypeServiceImpl implements PeriodTypeService {
    @Autowired
    PeriodTypeRepository periodTypeRepository;

    @Override
    public List<PeriodType> getAll() {
        return periodTypeRepository.findAll();
    }
}
