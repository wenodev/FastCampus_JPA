package com.example.FastJpa.service;

import com.example.FastJpa.domain.User;
import com.example.FastJpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserService userService = new UserService(userRepository);


    @Test
    void save_user(){
        User createUser = User.builder()
                .id(1L)
                .name("name")
                .build();

        //given
        given(userRepository.save(any(User.class))).willReturn(createUser);

        //when
        createUser = userService.create(createUser);

        //then
        assertThat(createUser.getName()).isEqualTo("name");
    }

}
