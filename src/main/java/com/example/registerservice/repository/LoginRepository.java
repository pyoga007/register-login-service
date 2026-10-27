package com.example.registerservice.repository;

import com.example.registerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    @Query("Select u.password from User where u.userId=:userId")
    String findPasswordByUserId(@Param("userId") String userId);
}
