package com.bangnd.hr.service;

import com.bangnd.hr.entity.AttendanceAskType;

import java.util.List;

public interface AttendanceAskTypeService {
    public List<AttendanceAskType> getAll();

    public AttendanceAskType getAttendanceAskTypeById(int id);
}