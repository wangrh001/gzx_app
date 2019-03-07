package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface CurriculumTypeService {
    public List<CurriculumType> getAll();

    public CurriculumType getCurriculumTypeById(int id);
}