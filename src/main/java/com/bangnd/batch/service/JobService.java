package com.bangnd.batch.service;

import com.bangnd.batch.entity.Job;
import com.bangnd.batch.form.JobSearchForm;

import java.util.List;

public interface JobService {
    public List<Job> getJobList(JobSearchForm jobSearchForm);

    public void save(Job job);

    public Job getJobById(long id);

    public void merge(Job job);
}