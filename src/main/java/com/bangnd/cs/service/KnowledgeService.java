package com.bangnd.cs.service;

import com.bangnd.cs.entity.Knowledge;
import com.bangnd.cs.form.KnowledgeSearchForm;

import java.util.List;

public interface KnowledgeService {
    public List<Knowledge> getKnowledgeList(KnowledgeSearchForm knowledgeSearchForm);

    public void save(Knowledge knowledge);

    public Knowledge getKnowledgeById(long id);

    public void merge(Knowledge knowledge);
}