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
}
