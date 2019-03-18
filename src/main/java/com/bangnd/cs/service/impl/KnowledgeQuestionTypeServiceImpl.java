package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.KnowledgeQuestionType;
import com.bangnd.cs.repository.KnowledgeQuestionTypeRepository;
import com.bangnd.cs.service.KnowledgeQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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