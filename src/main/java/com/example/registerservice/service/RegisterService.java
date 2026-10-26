package com.example.registerservice.service;

import com.example.registerservice.repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository=registerRepository;
    }
}
