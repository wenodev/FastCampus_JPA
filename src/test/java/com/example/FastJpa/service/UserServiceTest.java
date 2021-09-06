package com.example.FastJpa.service;

import com.example.FastJpa.domain.Address;
import com.example.FastJpa.domain.Gender;
import com.example.FastJpa.domain.User;
import com.example.FastJpa.domain.UserHistory;
import com.example.FastJpa.repository.UserHistoryRepository;
import com.example.FastJpa.repository.UserRepository;
import com.example.FastJpa.support.BeanUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserHistoryRepository userHistoryRepository = mock(UserHistoryRepository.class);
    private UserService userService = new UserService(userRepository);

    @Test
    void save_user(){
        Address homeAddress = Address.builder()
                .city("home-city")
                .build();

        User createUser = User.builder()
                .id(1L)
                .name("name")
                .gender(Gender.MALE)
                .homeAddress(homeAddress)
                .build();

        UserHistory createUserHistory = UserHistory.builder()
                .id(1L)
                .name("name")
                .gender(Gender.MALE)
                .user(createUser)
                .build();

        //given
        given(userRepository.save(any(User.class))).willReturn(createUser);
        given(userHistoryRepository.save(any(UserHistory.class))).willReturn(createUserHistory);

        //when
        createUser = userService.create(createUser);
        pre_post(createUser);

        //then
        assertThat(createUser.getName()).isEqualTo("name");
        assertThat(createUser.getGender()).isEqualTo(Gender.MALE);
        assertThat(createUser.getHomeAddress().getCity()).isEqualTo("home-city");

        assertThat(createUserHistory.getUser().getId()).isEqualTo(1L);
        assertThat(createUserHistory.getGender()).isEqualTo(Gender.MALE);
    }

    void pre_post(Object o){
        User user = (User) o;
        userHistoryRepository.save(
                UserHistory.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .user(user)
                        .build());
    }

}
