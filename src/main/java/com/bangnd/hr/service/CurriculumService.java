package com.bangnd.hr.service;

import com.bangnd.hr.entity.Curriculum;
import com.bangnd.hr.form.CurriculumSearchForm;

import java.util.List;

public interface CurriculumService {
    public List<Curriculum> getCurriculumList(CurriculumSearchForm curriculumSearchForm);

    public void save(Curriculum curriculum);

    public Curriculum getCurriculumById(long id);

    public void merge(Curriculum curriculum);
}