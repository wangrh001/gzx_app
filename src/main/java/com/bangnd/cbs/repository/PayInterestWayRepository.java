package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.PayInterestWay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayInterestWayRepository extends JpaRepository<PayInterestWay, Integer>, JpaSpecificationExecutor {


}
