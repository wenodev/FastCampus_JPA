package com.example.FastJpa.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void test_save_address(){
        user = User.builder()
                .homeAddress(Address.builder()
                        .city("city")
                        .detail("detail")
                        .build())
                .build();
    }

    @Test
    void test_print(){
        System.out.println(user);
    }

}
