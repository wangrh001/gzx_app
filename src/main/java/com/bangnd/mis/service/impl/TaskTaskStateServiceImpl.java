package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.*;
import com.bangnd.mis.service.*;
import com.bangnd.mis.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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