package com.bangnd.hr.service;

import com.bangnd.hr.entity.Curriculum;
import com.bangnd.hr.form.CurriculumSearchForm;
import org.springframework.data.domain.Page;

public interface CurriculumService {
    public Page<Curriculum> getCurriculumList(Integer pageNum, int size, CurriculumSearchForm curriculumSearchForm);

    public void save(Curriculum curriculum);

    public Curriculum getCurriculumById(long id);

    public void merge(Curriculum curriculum);
}