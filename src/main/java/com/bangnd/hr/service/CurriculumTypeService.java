package com.bangnd.hr.service;

import com.bangnd.hr.entity.CurriculumType;

import java.util.List;

public interface CurriculumTypeService {
    public List<CurriculumType> getAll();

    public CurriculumType getCurriculumTypeById(int id);
}