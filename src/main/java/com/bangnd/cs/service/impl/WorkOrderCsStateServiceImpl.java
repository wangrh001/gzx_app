package com.bangnd.cs.service.impl;
import  com.bangnd.cs.entity.*;
import  com.bangnd.cs.service.*;
import  com.bangnd.cs.repository.*;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkOrderCsStateServiceImpl implements WorkOrderCsStateService { 
@Autowired
private WorkOrderCsStateRepository workOrderCsStateRepository;
@Override
public List<WorkOrderCsState> getAll(){return workOrderCsStateRepository.findAll();}@Override
public WorkOrderCsState getWorkOrderCsStateById(int id){return workOrderCsStateRepository.findOne(id);}}