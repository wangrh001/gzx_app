package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.Attendance;
import com.bangnd.hr.form.AttendanceSearchForm;
import com.bangnd.hr.repository.AttendanceRepository;
import com.bangnd.hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public Page<Attendance> getAttendanceList(Integer pageNum, int size, AttendanceSearchForm attendanceSearchForm) {
        Specification specification = new Specification<Attendance>() {
            @Override
            public Predicate toPredicate(Root<Attendance> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (attendanceSearchForm.getEmpName() != null && !"".equals(attendanceSearchForm.getEmpName())) {
                    predicates.add(cb.like(root.get("empName").as(String.class), "%" + attendanceSearchForm.getEmpName() + "%"));
                }
                if (attendanceSearchForm.getMonth() != null && !"".equals(attendanceSearchForm.getMonth())) {
                    predicates.add(cb.like(root.get("month").as(String.class), "%" + attendanceSearchForm.getMonth() + "%"));
                }
                if (attendanceSearchForm.getWorkDayStart() != null && !"".equals(attendanceSearchForm.getWorkDayStart()) && attendanceSearchForm.getWorkDayEnd() != null && !"".equals(attendanceSearchForm.getWorkDayEnd())) {
                    predicates.add(cb.between(root.get("workDay").as(Date.class), attendanceSearchForm.getWorkDayStart(), attendanceSearchForm.getWorkDayEnd()));
                }
                if (attendanceSearchForm.getAskType() != null && !"".equals(attendanceSearchForm.getAskType())) {
                    if ("-1".equals(attendanceSearchForm.getAskType())) {
                        predicates.add(cb.notEqual(root.get("askType"), attendanceSearchForm.getAskType()));
                    } else {
                        predicates.add(cb.equal(root.get("askType"), attendanceSearchForm.getAskType()));
                    }
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Attendance> qyPage = this.attendanceRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public void save(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public void merge(Attendance attendance) {
        attendanceRepository.save(attendance);
    }
}