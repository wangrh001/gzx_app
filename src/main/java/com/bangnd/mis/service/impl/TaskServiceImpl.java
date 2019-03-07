package com.bangnd.mis.service.impl;

import com.bangnd.mis.entity.Task;
import com.bangnd.mis.service.*;
import com.bangnd.mis.form.TaskSearchForm;

import java.util.*;

import com.bangnd.mis.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTaskList(TaskSearchForm taskSearchForm) {
        Specification specification = new Specification<Task>() {
            @Override
            public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (taskSearchForm.getTaskName() != null && !"".equals(taskSearchForm.getTaskName())) {
                    predicates.add(cb.like(root.get("taskName").as(String.class), "%" + taskSearchForm.getTaskName() + "%"));
                }
                if (taskSearchForm.getType() != null && !"".equals(taskSearchForm.getType())) {
                    if ("0".equals(taskSearchForm.getType())) {
                        predicates.add(cb.notEqual(root.get("type"), taskSearchForm.getType()));
                    } else {
                        predicates.add(cb.equal(root.get("type"), taskSearchForm.getType()));
                    }
                }
                if (taskSearchForm.getTaskPeriod() != null && !"".equals(taskSearchForm.getTaskPeriod())) {
                    if ("0".equals(taskSearchForm.getTaskPeriod())) {
                        predicates.add(cb.notEqual(root.get("taskPeriod"), taskSearchForm.getTaskPeriod()));
                    } else {
                        predicates.add(cb.equal(root.get("taskPeriod"), taskSearchForm.getTaskPeriod()));
                    }
                }
                if (taskSearchForm.getTaskState() != null && !"".equals(taskSearchForm.getTaskState())) {
                    if ("0".equals(taskSearchForm.getTaskState())) {
                        predicates.add(cb.notEqual(root.get("taskState"), taskSearchForm.getTaskState()));
                    } else {
                        predicates.add(cb.equal(root.get("taskState"), taskSearchForm.getTaskState()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return taskRepository.findAll(specification);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void merge(Task task) {
        taskRepository.save(task);
    }
}