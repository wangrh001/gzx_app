package com.bangnd.hr.service;

import com.bangnd.hr.entity.CurriculumPosId;

import java.util.List;

public interface CurriculumPosIdService {
    public List<CurriculumPosId> getAll();

    public CurriculumPosId getCurriculumPosIdById(int id);
}