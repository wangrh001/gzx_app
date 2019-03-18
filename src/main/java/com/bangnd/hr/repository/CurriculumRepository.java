package com.bangnd.hr.repository;

import com.bangnd.hr.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long>, JpaSpecificationExecutor {
    public Curriculum findById(@Param(value = "id") long id);

    List<Curriculum> findByStateNot(@Param(value = "status") int status);
}