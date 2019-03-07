package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.*;
import com.bangnd.cs.service.*;
import com.bangnd.cs.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeQuestionTypeServiceImpl implements KnowledgeQuestionTypeService {
    @Autowired
    private KnowledgeQuestionTypeRepository knowledgeQuestionTypeRepository;

    @Override
    public List<KnowledgeQuestionType> getAll() {
        return knowledgeQuestionTypeRepository.findAll();
    }

    @Override
    public KnowledgeQuestionType getKnowledgeQuestionTypeById(int id) {
        return knowledgeQuestionTypeRepository.findOne(id);
    }
}