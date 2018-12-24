package com.bangnd.ums.repository;

import com.bangnd.ums.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    public List<UserRole> findAllByUserId(long id);
}
