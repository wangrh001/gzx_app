package com.bangnd.batch.service;

import com.bangnd.batch.entity.JobType;

import java.util.List;

public interface JobTypeService {
    public List<JobType> getAll();

    public JobType getJobTypeById(int id);
}