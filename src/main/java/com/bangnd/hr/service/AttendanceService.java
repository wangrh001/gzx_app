package com.bangnd.hr.service;

import com.bangnd.hr.entity.Attendance;
import com.bangnd.hr.form.AttendanceSearchForm;

import java.util.List;

public interface AttendanceService {
    public List<Attendance> getAttendanceList(AttendanceSearchForm attendanceSearchForm);

    public void save(Attendance attendance);

    public Attendance getAttendanceById(long id);

    public void merge(Attendance attendance);
}