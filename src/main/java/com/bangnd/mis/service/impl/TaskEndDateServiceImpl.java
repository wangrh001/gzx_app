package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.TaskEndDate;
import com.bangnd.mis.repository.TaskEndDateRepository;
import com.bangnd.mis.service.TaskEndDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskEndDateServiceImpl implements TaskEndDateService {
    @Autowired
    private TaskEndDateRepository taskEndDateRepository;

    @Override
    public List<TaskEndDate> getAll() {
        return taskEndDateRepository.findAll();
    }

    @Override
    public TaskEndDate getTaskEndDateById(int id) {
        return taskEndDateRepository.findOne(id);
    }
}