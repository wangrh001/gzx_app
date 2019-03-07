package com.bangnd.mis.service;

import com.bangnd.mis.entity.*;

import java.util.List;

public interface TaskTypeService {
    public List<TaskType> getAll();

    public TaskType getTaskTypeById(int id);
}