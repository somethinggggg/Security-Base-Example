package com.example.security.service;

import com.example.security.domain.dto.SignUpRequest;
import com.example.security.domain.model.Role;
import com.example.security.domain.model.User;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User registerUser(SignUpRequest signUpRequest) {
        if (userRepository.findByUsername(signUpRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

//        if (user.getRole() == null) {
//            Role role = new Role(Role.ROLE_USER);
//            user.setRole(role);
//        }

        return userRepository.save(user);
    }
}
