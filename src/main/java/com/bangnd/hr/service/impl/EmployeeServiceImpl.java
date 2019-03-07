package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.*;
import com.bangnd.hr.form.EmployeeSearchForm;

import java.util.*;

import com.bangnd.hr.repository.EmployeeRepository;
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
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList(EmployeeSearchForm employeeSearchForm) {
        Specification specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (employeeSearchForm.getName() != null && !"".equals(employeeSearchForm.getName())) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + employeeSearchForm.getName() + "%"));
                }
                if (employeeSearchForm.getBirthday() != null && !"".equals(employeeSearchForm.getBirthday())) {
                    predicates.add(cb.like(root.get("birthday").as(String.class), "%" + employeeSearchForm.getBirthday() + "%"));
                }
                if (employeeSearchForm.getCity() != null && !"".equals(employeeSearchForm.getCity())) {
                    if ("0".equals(employeeSearchForm.getCity())) {
                        predicates.add(cb.notEqual(root.get("city"), employeeSearchForm.getCity()));
                    } else {
                        predicates.add(cb.equal(root.get("city"), employeeSearchForm.getCity()));
                    }
                }
                if (employeeSearchForm.getDept() != null && !"".equals(employeeSearchForm.getDept())) {
                    if ("0".equals(employeeSearchForm.getDept())) {
                        predicates.add(cb.notEqual(root.get("dept"), employeeSearchForm.getDept()));
                    } else {
                        predicates.add(cb.equal(root.get("dept"), employeeSearchForm.getDept()));
                    }
                }
                if (employeeSearchForm.getManageGrade() != null && !"".equals(employeeSearchForm.getManageGrade())) {
                    if ("0".equals(employeeSearchForm.getManageGrade())) {
                        predicates.add(cb.notEqual(root.get("manageGrade"), employeeSearchForm.getManageGrade()));
                    } else {
                        predicates.add(cb.equal(root.get("manageGrade"), employeeSearchForm.getManageGrade()));
                    }
                }
                if (employeeSearchForm.getTechGrade() != null && !"".equals(employeeSearchForm.getTechGrade())) {
                    if ("0".equals(employeeSearchForm.getTechGrade())) {
                        predicates.add(cb.notEqual(root.get("techGrade"), employeeSearchForm.getTechGrade()));
                    } else {
                        predicates.add(cb.equal(root.get("techGrade"), employeeSearchForm.getTechGrade()));
                    }
                }
                if (employeeSearchForm.getPhone() != null && !"".equals(employeeSearchForm.getPhone())) {
                    predicates.add(cb.like(root.get("phone").as(String.class), "%" + employeeSearchForm.getPhone() + "%"));
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return employeeRepository.findAll(specification);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void merge(Employee employee) {
        employeeRepository.save(employee);
    }
}