package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.BTaskResult;
import com.bangnd.batch.repository.BTaskResultRepository;
import com.bangnd.batch.service.BTaskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BTaskResultServiceImpl implements BTaskResultService {
    @Autowired
    private BTaskResultRepository BTaskResultRepository;

    @Override
    public List<BTaskResult> getAll() {
        return BTaskResultRepository.findAll();
    }

    @Override
    public BTaskResult getBTaskResultById(int id) {
        return BTaskResultRepository.findOne(id);
    }
}