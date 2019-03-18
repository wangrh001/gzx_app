package com.bangnd.ums.repository;

import com.bangnd.ums.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor {
    public UserRole findById(@Param(value = "id") long id);

    List<UserRole> findByStateNot(@Param(value = "status") int status);

    @Query("select u from UserRole  u where userId=:userId and state <> 100")
    public List<UserRole> findAllByUserId(@Param(value = "userId") long userId);

    @Query("select u from UserRole  u where roleId=:roleId and state <> 100")
    public List<UserRole> findAllByRoleId(@Param(value = "roleId") long roleId);
}