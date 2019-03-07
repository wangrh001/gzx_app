package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.*;
import com.bangnd.batch.service.*;
import com.bangnd.batch.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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