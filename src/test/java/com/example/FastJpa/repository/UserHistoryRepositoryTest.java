package com.example.FastJpa.repository;

import com.example.FastJpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
class UserHistoryRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void test_printAll(){
        userRepository.save(User.builder()
                        .email("aa")
                        .name("bb")
                        .build());

        System.out.println(userHistoryRepository.findAll());
    }

}
