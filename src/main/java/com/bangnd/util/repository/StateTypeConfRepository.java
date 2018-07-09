package com.bangnd.util.repository;

import com.bangnd.util.entity.EstateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateTypeConfRepository extends JpaRepository<EstateType, Long> {
}
