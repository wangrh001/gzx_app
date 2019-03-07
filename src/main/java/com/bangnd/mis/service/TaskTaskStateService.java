package com.bangnd.mis.service;

import com.bangnd.mis.entity.*;

import java.util.List;

public interface TaskTaskStateService {
    public List<TaskTaskState> getAll();

    public TaskTaskState getTaskTaskStateById(int id);
}