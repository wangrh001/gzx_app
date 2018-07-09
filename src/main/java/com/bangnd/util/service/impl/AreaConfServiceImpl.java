package com.bangnd.util.service.impl;

import com.bangnd.util.entity.EstateArea;
import com.bangnd.util.repository.AreaConfRepository;
import com.bangnd.util.service.AreaConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaConfServiceImpl implements AreaConfService {
    @Autowired
    AreaConfRepository areaConfRepository;

    @Override
    public List<EstateArea> getAll() {
        return areaConfRepository.findAll();
    }
}
