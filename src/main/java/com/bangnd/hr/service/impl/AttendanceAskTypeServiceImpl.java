package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.AttendanceAskType;
import com.bangnd.hr.repository.AttendanceAskTypeRepository;
import com.bangnd.hr.service.AttendanceAskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceAskTypeServiceImpl implements AttendanceAskTypeService {
    @Autowired
    private AttendanceAskTypeRepository attendanceAskTypeRepository;

    @Override
    public List<AttendanceAskType> getAll() {
        return attendanceAskTypeRepository.findAll();
    }

    @Override
    public AttendanceAskType getAttendanceAskTypeById(int id) {
        return attendanceAskTypeRepository.findOne(id);
    }
}