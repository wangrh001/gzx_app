package com.bangnd.cs.service;
import com.bangnd.cs.entity.WorkOrder;
import com.bangnd.cs.form.WorkOrderSearchForm;
import java.util.List;
public interface WorkOrderService{
public List<WorkOrder> getWorkOrderList(WorkOrderSearchForm workOrderSearchForm);public void save(WorkOrder workOrder);public WorkOrder getWorkOrderById(long id);public void merge(WorkOrder workOrder);}