package com.example.registerservice.repository;

import com.example.registerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);
}
