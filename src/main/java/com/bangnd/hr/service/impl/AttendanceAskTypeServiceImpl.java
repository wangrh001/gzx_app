package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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