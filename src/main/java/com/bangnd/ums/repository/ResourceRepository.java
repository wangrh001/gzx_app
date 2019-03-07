package com.bangnd.ums.repository;

import com.bangnd.ums.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query("select r from Resource  r where r.parentId = :parentId and r.state = 1")
    public List<Resource> findAllByParentId(@Param(value = "parentId") long parentId);
}
