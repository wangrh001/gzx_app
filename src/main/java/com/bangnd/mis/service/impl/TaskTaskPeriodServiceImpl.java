package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.*;
import com.bangnd.mis.service.*;
import com.bangnd.mis.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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