package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface CurriculumPosIdService {
    public List<CurriculumPosId> getAll();

    public CurriculumPosId getCurriculumPosIdById(int id);
}