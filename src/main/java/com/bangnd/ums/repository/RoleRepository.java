package com.bangnd.ums.repository;

import com.bangnd.ums.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor {
    public Role findById(@Param(value = "id") long id);

    List<Role> findByStateNot(@Param(value = "status") int status);


}