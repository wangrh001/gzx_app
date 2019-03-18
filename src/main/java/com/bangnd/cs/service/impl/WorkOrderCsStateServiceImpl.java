package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.WorkOrderCsState;
import com.bangnd.cs.repository.WorkOrderCsStateRepository;
import com.bangnd.cs.service.WorkOrderCsStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkOrderCsStateServiceImpl implements WorkOrderCsStateService { 
@Autowired
private WorkOrderCsStateRepository workOrderCsStateRepository;
@Override
public List<WorkOrderCsState> getAll(){return workOrderCsStateRepository.findAll();}@Override
public WorkOrderCsState getWorkOrderCsStateById(int id){return workOrderCsStateRepository.findOne(id);}}