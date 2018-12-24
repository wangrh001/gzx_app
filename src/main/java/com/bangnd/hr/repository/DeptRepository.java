package com.bangnd.hr.repository;

import com.bangnd.hr.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {
}
