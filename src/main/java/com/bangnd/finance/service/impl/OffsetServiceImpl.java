package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.Offset;
import com.bangnd.finance.repository.OffsetRepository;
import com.bangnd.finance.service.OffsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffsetServiceImpl implements OffsetService {

    @Autowired
    OffsetRepository offsetRepository;

    @Override
    public List<Offset> getAll() {
        return offsetRepository.findAll();
    }
}
