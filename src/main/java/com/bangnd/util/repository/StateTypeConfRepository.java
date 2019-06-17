package com.bangnd.util.repository;

import com.bangnd.bridgecbs.entity.MortgageEstateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateTypeConfRepository extends JpaRepository<MortgageEstateType, Long> {
}
