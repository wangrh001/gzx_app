package com.bangnd.batch.service;

import com.bangnd.batch.entity.BTaskResult;

import java.util.List;

public interface BTaskResultService {
    public List<BTaskResult> getAll();

    public BTaskResult getBTaskResultById(int id);
}