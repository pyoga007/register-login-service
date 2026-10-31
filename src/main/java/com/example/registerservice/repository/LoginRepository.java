package com.example.registerservice.repository;

import com.example.registerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    boolean existsByUserId(String userId);
    @Query("SELECT u.password from User u where u.userId=:userId")
    Optional<String> findPasswordByUserId(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE User u set u.lastLogin=:lastLogin where u.userId=:userId")
    void setLastLoginForUserId(@Param("userId") String userId, @Param("lastLogin")LocalDateTime lastLogin);
}
