package com.bangnd.util.service;

import com.bangnd.util.entity.PeriodType;

import java.util.List;

public interface PeriodTypeService {
    public List<PeriodType> getAll();

    public PeriodType getPeriodTypeById(int id);
}
