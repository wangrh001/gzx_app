package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.*;
import com.bangnd.mis.service.*;
import com.bangnd.mis.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Override
    public List<TaskType> getAll() {
        return taskTypeRepository.findAll();
    }

    @Override
    public TaskType getTaskTypeById(int id) {
        return taskTypeRepository.findOne(id);
    }
}