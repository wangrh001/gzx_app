package com.bangnd.ums.repository;

import com.bangnd.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {
    public User findById(@Param(value = "id") long id);

    List<User> findByStateNot(@Param(value = "status") int status);

    @Query("select u from User u where u.userName=:userName")
    public User findUserByUserName(@Param("userName") String userName);

}