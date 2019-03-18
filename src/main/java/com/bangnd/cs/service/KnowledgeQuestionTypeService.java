package com.bangnd.cs.service;

import com.bangnd.cs.entity.KnowledgeQuestionType;

import java.util.List;

public interface KnowledgeQuestionTypeService {
    public List<KnowledgeQuestionType> getAll();

    public KnowledgeQuestionType getKnowledgeQuestionTypeById(int id);
}