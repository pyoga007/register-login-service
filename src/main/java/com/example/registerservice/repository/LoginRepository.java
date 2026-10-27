package com.example.registerservice.repository;

import com.example.registerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    boolean existsByUserId(String userId);
    @Query("SELECT u.password from User u where u.userId=:userId")
    Optional<String> findPasswordByUserId(@Param("userId") String userId);
}
