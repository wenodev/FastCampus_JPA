package com.example.FastJpa.domain.listener;

import com.example.FastJpa.domain.User;
import com.example.FastJpa.domain.UserHistory;
import com.example.FastJpa.repository.UserHistoryRepository;
import com.example.FastJpa.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    public void postPersist(Object o){
        System.out.println("저장 시작");

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;
        userHistoryRepository.save(
                UserHistory.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .user(user)
                        .build());

        System.out.println("저장 끝");
    }

    @PostUpdate
    public void postUpdate(Object o){
        System.out.println("수정 시작");

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;
        userHistoryRepository.save(
                UserHistory.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .user(user)
                        .build());

        System.out.println("수정 끝");
    }

}
