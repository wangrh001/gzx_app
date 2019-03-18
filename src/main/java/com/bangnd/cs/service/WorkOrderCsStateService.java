package com.bangnd.cs.service;

import com.bangnd.cs.entity.WorkOrderCsState;

import java.util.List;

public interface WorkOrderCsStateService{
public List<WorkOrderCsState> getAll();public WorkOrderCsState getWorkOrderCsStateById(int id);}