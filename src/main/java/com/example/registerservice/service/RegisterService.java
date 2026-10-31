package com.example.registerservice.service;

import com.example.registerservice.dto.UserDTO;
import com.example.registerservice.entity.User;
import com.example.registerservice.repository.RegisterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(RegisterRepository registerRepository,PasswordEncoder passwordEncoder){
        this.registerRepository=registerRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public boolean userExists(String email) {
        return registerRepository.existsByEmail(email);
    }

    public User createUser(UserDTO userDto) {
        User user=new User(userDto);
        user.setCreationDate(LocalDateTime.now());
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return registerRepository.save(user);
    }

    public boolean userIdExists(String userId) {
        return registerRepository.existsByUserId(userId);
    }
}
