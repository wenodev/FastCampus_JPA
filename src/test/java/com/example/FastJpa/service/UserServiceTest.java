package com.example.FastJpa.service;

import com.example.FastJpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserService userService = new UserService(userRepository);

    @BeforeEach
    void test(){

    }

}
