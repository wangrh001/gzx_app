package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRepository extends JpaRepository<Mortgage, Long> {
}
