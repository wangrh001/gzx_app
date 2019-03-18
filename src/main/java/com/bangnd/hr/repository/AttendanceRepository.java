package com.bangnd.hr.repository;

import com.bangnd.hr.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>, JpaSpecificationExecutor {
    public Attendance findById(@Param(value = "id") long id);

    List<Attendance> findByStateNot(@Param(value = "status") int status);
}