package com.bangnd.mis.service;

import com.bangnd.mis.entity.TaskEndDate;

import java.util.List;

public interface TaskEndDateService {
    public List<TaskEndDate> getAll();

    public TaskEndDate getTaskEndDateById(int id);
}