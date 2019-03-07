package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.*;
import com.bangnd.mis.service.*;
import com.bangnd.mis.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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