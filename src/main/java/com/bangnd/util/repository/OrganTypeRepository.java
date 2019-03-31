package com.bangnd.util.repository;

import com.bangnd.util.entity.OrganType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface OrganTypeRepository extends JpaRepository<OrganType, Integer> {

    public OrganType getOrganTypeById(@Param(value="id") int id);
}
