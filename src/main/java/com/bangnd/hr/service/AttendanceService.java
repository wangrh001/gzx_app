package com.bangnd.hr.service;

import com.bangnd.hr.entity.Attendance;
import com.bangnd.hr.form.AttendanceSearchForm;
import org.springframework.data.domain.Page;

public interface AttendanceService {
    public Page<Attendance> getAttendanceList(Integer pageNum, int size, AttendanceSearchForm attendanceSearchForm);

    public void save(Attendance attendance);

    public Attendance getAttendanceById(long id);

    public void merge(Attendance attendance);
}