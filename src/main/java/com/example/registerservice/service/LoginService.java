package com.example.registerservice.service;

import com.example.registerservice.dto.LoginDTO;
import com.example.registerservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(LoginRepository loginRepository,PasswordEncoder passwordEncoder){
        this.loginRepository=loginRepository;
        this.passwordEncoder=passwordEncoder;
    }


    public boolean authenticate(LoginDTO loginDTO) {
        if(!loginRepository.existsByUserId(loginDTO.getUserId()))
            return false;
       Optional<String> encodedPassword=loginRepository.findPasswordByUserId(loginDTO.getUserId());

        if(passwordEncoder.matches(loginDTO.getPassword(), encodedPassword.get())){
             loginRepository.setLastLoginForUserId(loginDTO.getUserId(), LocalDateTime.now());
             return true;
        }
        return false;
    }
}
