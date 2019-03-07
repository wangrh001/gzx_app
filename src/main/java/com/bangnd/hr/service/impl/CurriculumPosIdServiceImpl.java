package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumPosIdServiceImpl implements CurriculumPosIdService {
    @Autowired
    private CurriculumPosIdRepository curriculumPosIdRepository;

    @Override
    public List<CurriculumPosId> getAll() {
        return curriculumPosIdRepository.findAll();
    }

    @Override
    public CurriculumPosId getCurriculumPosIdById(int id) {
        return curriculumPosIdRepository.findOne(id);
    }
}