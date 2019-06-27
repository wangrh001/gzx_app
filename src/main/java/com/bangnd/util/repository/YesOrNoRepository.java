package com.bangnd.util.repository;

import com.bangnd.util.entity.YesOrNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface YesOrNoRepository extends JpaRepository<YesOrNo, Integer>, JpaSpecificationExecutor {
}
