package com.bangnd.batch.repository;

import com.bangnd.batch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyJobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor {
    public Job findById(@Param(value = "id") long id);

    List<Job> findByStateNot(@Param(value = "status") int status);
}