package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.WorkOrder;
import com.bangnd.cs.form.WorkOrderSearchForm;
import com.bangnd.cs.repository.WorkOrderRepository;
import com.bangnd.cs.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
public class WorkOrderServiceImpl implements WorkOrderService{
@Autowired
private WorkOrderRepository workOrderRepository;public List<WorkOrder> getWorkOrderList(WorkOrderSearchForm workOrderSearchForm){Specification specification = new Specification<WorkOrder>() {@Override
public Predicate toPredicate(Root<WorkOrder> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {List<Predicate> predicates = new ArrayList<Predicate>();if (workOrderSearchForm.getCsName()!=null && !"".equals(workOrderSearchForm.getCsName())) {
predicates.add(cb.like(root.get("csName").as(String.class), "%" + workOrderSearchForm.getCsName() + "%"));}
if (workOrderSearchForm.getCstype()!=null && !"".equals(workOrderSearchForm.getCstype())) {
   if("0".equals(workOrderSearchForm.getCstype())){
        predicates.add(cb.notEqual(root.get("cstype"), workOrderSearchForm.getCstype()));
   }else {
        predicates.add(cb.equal(root.get("cstype"), workOrderSearchForm.getCstype()));
   }
}if (workOrderSearchForm.getOrderId()!=null && !"".equals(workOrderSearchForm.getOrderId())) {
predicates.add(cb.like(root.get("orderId").as(String.class), "%" + workOrderSearchForm.getOrderId() + "%"));}
if (workOrderSearchForm.getCustomerName()!=null && !"".equals(workOrderSearchForm.getCustomerName())) {
predicates.add(cb.like(root.get("customerName").as(String.class), "%" + workOrderSearchForm.getCustomerName() + "%"));}
if (workOrderSearchForm.getCsState()!=null && !"".equals(workOrderSearchForm.getCsState())) {
   if("0".equals(workOrderSearchForm.getCsState())){
        predicates.add(cb.notEqual(root.get("csState"), workOrderSearchForm.getCsState()));
   }else {
        predicates.add(cb.equal(root.get("csState"), workOrderSearchForm.getCsState()));
   }
}predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));Predicate[] p = new Predicate[predicates.size()];
return cb.and(predicates.toArray(p));}};return workOrderRepository.findAll(specification);}@Override
public void save(WorkOrder workOrder){workOrderRepository.save(workOrder);}@Override
public WorkOrder getWorkOrderById(long id){return workOrderRepository.findById(id);}@Override
public void merge(WorkOrder workOrder){workOrderRepository.save(workOrder);}}