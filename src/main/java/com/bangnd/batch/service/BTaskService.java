package com.bangnd.batch.service;

import com.bangnd.batch.entity.BTask;
import com.bangnd.batch.form.BTaskSearchForm;

import java.util.List;

public interface BTaskService {
    public List<BTask> getBTaskList(BTaskSearchForm BTaskSearchForm);

    public void save(BTask BTask);

    public BTask getBTaskById(long id);

    public void merge(BTask BTask);
}