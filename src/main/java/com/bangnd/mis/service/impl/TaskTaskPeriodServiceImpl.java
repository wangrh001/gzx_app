package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.TaskTaskPeriod;
import com.bangnd.mis.repository.TaskTaskPeriodRepository;
import com.bangnd.mis.service.TaskTaskPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTaskPeriodServiceImpl implements TaskTaskPeriodService {
    @Autowired
    private TaskTaskPeriodRepository taskTaskPeriodRepository;

    @Override
    public List<TaskTaskPeriod> getAll() {
        return taskTaskPeriodRepository.findAll();
    }

    @Override
    public TaskTaskPeriod getTaskTaskPeriodById(int id) {
        return taskTaskPeriodRepository.findOne(id);
    }
}