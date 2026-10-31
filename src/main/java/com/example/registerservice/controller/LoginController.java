
package com.example.registerservice.controller;

import com.example.registerservice.dto.LoginDTO;
import com.example.registerservice.exception.InvalidUserPasswordException;
import com.example.registerservice.security.JwtService;
import com.example.registerservice.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;
    private final JwtService jwtService;

    public LoginController(
            LoginService loginService,
            JwtService jwtService) {

        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody LoginDTO loginDTO) {

        // Validate input
        if (loginDTO.getUserId() == null ||
                loginDTO.getUserId().isBlank() ||
                loginDTO.getPassword() == null ||
                loginDTO.getPassword().isBlank()) {

            throw new InvalidUserPasswordException(
                    "Invalid userId or password"
            );
        }

        // Authenticate user
        if (loginService.authenticate(loginDTO)) {

            // Generate JWT token
            String token = jwtService.generateToken(
                    loginDTO.getUserId()
            );

            return ResponseEntity.status(HttpStatus.OK).body(
                    Map.of(
                            "message", "User " +
                                    loginDTO.getUserId() +
                                    " logged in successfully.",
                            "token", token
                    )
            );
        }

        throw new InvalidUserPasswordException(
                "Invalid userId or password"
        );
    }
}
