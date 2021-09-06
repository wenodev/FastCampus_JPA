package com.example.FastJpa.service;

import com.example.FastJpa.domain.User;
import com.example.FastJpa.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserService userService = new UserService(userRepository);

    @Test
    void save_user(){
        User user = userService.create(User.builder()
                .id(1L)
                .name("name")
                .build());
    }

}
