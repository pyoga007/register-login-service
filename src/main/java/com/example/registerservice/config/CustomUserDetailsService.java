
package com.example.registerservice.security;

import com.example.registerservice.entity.User;
import com.example.registerservice.repository.RegisterRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final RegisterRepository registerRepository;

    public CustomUserDetailsService(
            RegisterRepository registerRepository) {

        this.registerRepository = registerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {

        User user = registerRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found: " + userId
                        )
                );

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserId())
                .password(user.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
