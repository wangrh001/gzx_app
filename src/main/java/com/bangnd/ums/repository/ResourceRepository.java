package com.bangnd.ums.repository;

import com.bangnd.ums.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long>, JpaSpecificationExecutor {
    public Resource findById(@Param(value = "id") long id);

    List<Resource> findByStateNot(@Param(value = "status") int status);

    @Query("select r from Resource  r where r.parentId = :parentId and r.state <> 100")
    public List<Resource> findAllByParentId(@Param(value = "parentId") long parentId);

    @Query("select r from Resource  r where r.grade = :gradeId and r.state <> 100")
    public List<Resource> finAllByGrade(@Param(value="gradeId") int gradeId);

    @Query("select r from Resource  r where r.type = :type and r.state <> 100")
    public List<Resource> findAllByType(@Param(value="type") int type);

    @Query("select r from Resource  r where r.busiType = :busiType and r.state <> 100")
    public List<Resource> findAllByBusiType(@Param(value="busiType") int busiType);

    @Query("select r from Resource  r where r.grade =1 and r.state <> 100 and r.id <> -1")
    public List<Resource> findAllByGrade();

}