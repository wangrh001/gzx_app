package com.bangnd.batch.repository;

import com.bangnd.batch.entity.BTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BTaskRepository extends JpaRepository<BTask, Long>, JpaSpecificationExecutor {
    public BTask findById(@Param(value = "id") long id);

    List<BTask> findByStateNot(@Param(value = "status") int status);
}