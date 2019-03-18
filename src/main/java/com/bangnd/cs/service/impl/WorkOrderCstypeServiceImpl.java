package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.WorkOrderCstype;
import com.bangnd.cs.repository.WorkOrderCstypeRepository;
import com.bangnd.cs.service.WorkOrderCstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkOrderCstypeServiceImpl implements WorkOrderCstypeService { 
@Autowired
private WorkOrderCstypeRepository workOrderCstypeRepository;
@Override
public List<WorkOrderCstype> getAll(){return workOrderCstypeRepository.findAll();}@Override
public WorkOrderCstype getWorkOrderCstypeById(int id){return workOrderCstypeRepository.findOne(id);}}