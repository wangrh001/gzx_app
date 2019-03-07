package com.bangnd.cs.service.impl;
import  com.bangnd.cs.entity.*;
import  com.bangnd.cs.service.*;
import  com.bangnd.cs.repository.*;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkOrderCstypeServiceImpl implements WorkOrderCstypeService { 
@Autowired
private WorkOrderCstypeRepository workOrderCstypeRepository;
@Override
public List<WorkOrderCstype> getAll(){return workOrderCstypeRepository.findAll();}@Override
public WorkOrderCstype getWorkOrderCstypeById(int id){return workOrderCstypeRepository.findOne(id);}}