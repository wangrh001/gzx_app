package com.bangnd.mis.service;

import com.bangnd.mis.entity.*;

import java.util.List;

public interface TaskTaskPeriodService {
    public List<TaskTaskPeriod> getAll();

    public TaskTaskPeriod getTaskTaskPeriodById(int id);
}