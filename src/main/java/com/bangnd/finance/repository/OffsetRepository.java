package com.bangnd.finance.repository;

import com.bangnd.finance.entity.Offset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OffsetRepository extends JpaRepository<Offset, Integer>, JpaSpecificationExecutor {

}
