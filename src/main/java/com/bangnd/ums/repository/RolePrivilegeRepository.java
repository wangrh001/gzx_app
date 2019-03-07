package com.bangnd.ums.repository;

import com.bangnd.ums.entity.RolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, Long> {

    @Query("select r from RolePrivilege r where r.roleId=:roleId and r.state=1")
    public List<RolePrivilege> findAllByRole(@Param("roleId") long roleId);
}
