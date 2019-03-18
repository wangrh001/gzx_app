package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.TaskTaskState;
import com.bangnd.mis.repository.TaskTaskStateRepository;
import com.bangnd.mis.service.TaskTaskStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTaskStateServiceImpl implements TaskTaskStateService {
    @Autowired
    private TaskTaskStateRepository taskTaskStateRepository;

    @Override
    public List<TaskTaskState> getAll() {
        return taskTaskStateRepository.findAll();
    }

    @Override
    public TaskTaskState getTaskTaskStateById(int id) {
        return taskTaskStateRepository.findOne(id);
    }
}