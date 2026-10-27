package com.example.registerservice.controller;

import com.example.registerservice.dto.RegisterResponseDTO;
import com.example.registerservice.dto.UserDTO;
import com.example.registerservice.entity.User;
import com.example.registerservice.exception.EmailAlreadyExists;
import com.example.registerservice.exception.UserIdAlreadyExists;
import com.example.registerservice.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService=registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody UserDTO userDto){
        if(registerService.userIdExists(userDto.getUserId())){
            throw new UserIdAlreadyExists("The userId "+userDto.getUserId()+" already exists");
        }
        if(!registerService.userExists(userDto.getEmail())) {
            User user = registerService.createUser(userDto);
            RegisterResponseDTO responseDTO = new RegisterResponseDTO(user);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }
        throw new EmailAlreadyExists("The email id "+ userDto.getEmail()+" already exists");
    }
}
