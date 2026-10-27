package com.example.registerservice.service;

import com.example.registerservice.dto.LoginDTO;
import com.example.registerservice.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }


    public boolean authenticate(LoginDTO loginDTO) {
       String password=loginRepository.findPasswordByUserId(loginDTO.getUserId());
       return password.equals(loginDTO.getPassword());
    }
}
