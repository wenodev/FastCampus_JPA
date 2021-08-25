package com.example.FastJpa.repository;

import com.example.FastJpa.domain.Gender;
import com.example.FastJpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserHistoryRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void test_printAll(){
        System.out.println("=====0=====");
        userRepository.findAll().forEach(System.out::println);
//        userRepository.save(User.builder().name("name").email("email").gender(Gender.MALE).build());
//
//        System.out.println("=====1=====");
//        System.out.println(userHistoryRepository.findAll());
//
//        System.out.println("=====1.5=====");
//        System.out.println(userHistoryRepository.findAll().size());
//
//        System.out.println("=====2=====");
//        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        user.setName("updatedName");
//        user.setEmail("updatedEmail");
//
//        System.out.println("=====3=====");
//        userRepository.save(user);
//
//        System.out.println("=====4=====");
//        userRepository.save(User.builder().name("name2").email("email2").gender(Gender.MALE).build());
//
//        System.out.println("=====5=====");
//        System.out.println(userRepository.findAll());
//
//        System.out.println("=====6=====");
    }

    @Test
    void test(){
        userRepository.save(User.builder().name("name").email("email").gender(Gender.MALE).build());
//        System.out.println(userRepository.findById(1L).orElseThrow(RuntimeException::new).getUserHistories());
    }
}
