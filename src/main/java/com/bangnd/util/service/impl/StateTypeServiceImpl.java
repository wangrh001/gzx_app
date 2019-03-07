package com.bangnd.util.service.impl;

import com.bangnd.util.entity.EstateType;
import com.bangnd.util.repository.StateTypeConfRepository;
import com.bangnd.util.service.StateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateTypeServiceImpl implements StateTypeService {
    @Autowired
    StateTypeConfRepository stateTypeConfRepository;

    @Override
    public List<EstateType> getAll() {
        return stateTypeConfRepository.findAll();
    }
}
