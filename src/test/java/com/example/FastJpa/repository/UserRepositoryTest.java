package com.example.FastJpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_print(){
        userRepository.findAll().forEach(System.out::println);
    }

}
