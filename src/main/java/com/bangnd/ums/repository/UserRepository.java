package com.bangnd.ums.repository;

import com.bangnd.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.userName=:userName")
    public User findUserByUserName(@Param("userName") String userName);
}
