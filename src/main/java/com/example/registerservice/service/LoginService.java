package com.example.registerservice.service;

import com.example.registerservice.dto.LoginDTO;
import com.example.registerservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }


    public boolean authenticate(LoginDTO loginDTO) {
        if(!loginRepository.existsByUserId(loginDTO.getUserId()))
            return false;
       Optional<String> password=loginRepository.findPasswordByUserId(loginDTO.getUserId());
        if(password.get().equals(loginDTO.getPassword())){
             loginRepository.setLastLoginForUserId(loginDTO.getUserId(), LocalDateTime.now());
             return true;
        }
        return false;
    }
}
