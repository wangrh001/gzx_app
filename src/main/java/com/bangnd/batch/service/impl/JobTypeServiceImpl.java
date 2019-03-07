package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.*;
import com.bangnd.batch.service.*;
import com.bangnd.batch.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTypeServiceImpl implements JobTypeService {
    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Override
    public List<JobType> getAll() {
        return jobTypeRepository.findAll();
    }

    @Override
    public JobType getJobTypeById(int id) {
        return jobTypeRepository.findOne(id);
    }
}