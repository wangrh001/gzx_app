package com.bangnd.batch.service.impl;

import com.bangnd.batch.entity.JobType;
import com.bangnd.batch.repository.JobTypeRepository;
import com.bangnd.batch.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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