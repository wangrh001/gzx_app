package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.CurriculumPosId;
import com.bangnd.hr.repository.CurriculumPosIdRepository;
import com.bangnd.hr.service.CurriculumPosIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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