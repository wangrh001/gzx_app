package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.CurriculumType;
import com.bangnd.hr.repository.CurriculumTypeRepository;
import com.bangnd.hr.service.CurriculumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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