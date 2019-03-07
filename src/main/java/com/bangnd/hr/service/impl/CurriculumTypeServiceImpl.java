package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumTypeServiceImpl implements CurriculumTypeService {
    @Autowired
    private CurriculumTypeRepository curriculumTypeRepository;

    @Override
    public List<CurriculumType> getAll() {
        return curriculumTypeRepository.findAll();
    }

    @Override
    public CurriculumType getCurriculumTypeById(int id) {
        return curriculumTypeRepository.findOne(id);
    }
}