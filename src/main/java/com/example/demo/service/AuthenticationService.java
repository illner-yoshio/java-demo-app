package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean authenticate(String userId, String password) {

        Optional<UserEntity> user = userRepository.findByUserId(userId);

        if (user.isEmpty()) {
            return false;
        }

        UserEntity userEntity = user.get();

        return passwordEncoder.matches(
                password,
                userEntity.getPasswordHash()
        );
    }
}