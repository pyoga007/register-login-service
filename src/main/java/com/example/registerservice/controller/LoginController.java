package com.example.registerservice.controller;

import com.example.registerservice.dto.LoginDTO;
import com.example.registerservice.exception.InvalidUserPasswordException;
import com.example.registerservice.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        if(loginService.authenticate(loginDTO))
            return new ResponseEntity<>("User "+loginDTO.getUserId()+" is logged in successfully.", HttpStatus.ACCEPTED);

        throw new InvalidUserPasswordException("Invalid userId or password");
    }

}
