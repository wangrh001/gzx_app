package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.TaskType;
import com.bangnd.mis.repository.TaskTypeRepository;
import com.bangnd.mis.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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