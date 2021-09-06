package com.example.FastJpa.service;

import com.example.FastJpa.domain.User;
import com.example.FastJpa.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User name) {
        return userRepository.save(name);
    }
}
