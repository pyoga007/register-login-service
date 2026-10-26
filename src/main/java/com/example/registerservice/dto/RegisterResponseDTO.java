package com.example.registerservice.dto;

import com.example.registerservice.entity.User;

import java.time.LocalDateTime;

public class RegisterResponseDTO {
    private Long id;
    private String email;
    private LocalDateTime creationDate;

    public RegisterResponseDTO(User user){
        this.id= user.getUid();
        this.email= user.getEmail();
        this.creationDate=user.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
