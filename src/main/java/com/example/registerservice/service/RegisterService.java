package com.example.registerservice.service;

import com.example.registerservice.dto.UserDTO;
import com.example.registerservice.entity.User;
import com.example.registerservice.repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository=registerRepository;
    }

    public boolean userExists(String email) {
        return registerRepository.existsByEmail(email);
    }

    public User createUser(UserDTO userDto) {
        return registerRepository.save(new User(userDto));
    }

    public boolean userIdExists(String userId) {
        return registerRepository.existsByUserId(userId);
    }
}
