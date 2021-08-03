package com.example.FastJpa.repository;

import com.example.FastJpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // select
    List<User> findByEmail(String email);
    List<User> getByEmail(String email);
    List<User> readByEmail(String email);
    List<User> queryByEmail(String email);
    List<User> searchByEmail(String email);
    List<User> streamByEmail(String email);
    List<User> findUserByEmail(String email);
    List<User> findSomethingByEmail(String email);

    // select with limit
    List<User> findTopByName(String name);
    List<User> findTop1ByName(String name);
    List<User> findTop2ByName(String name);
    List<User> findFirst2ByName(String name);
    List<User> findLast1ByName(String name);


    // select with logical operator
    List<User> findByEmailAndName(String email, String name);
    List<User> findByEmailOrName(String email, String name);


    // select with comparison operator
    List<User> findByCreatedAtAfter(LocalDateTime date);
    List<User> findByCreatedAtGreaterThan(LocalDateTime date);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime date);
    List<User> findByCreatedAtBetween(LocalDateTime minusDays, LocalDateTime plusDays);
    List<User> findByCreatedAtBefore(LocalDateTime date);
    List<User> findByCreatedAtLessThan(LocalDateTime date);
    List<User> findByCreatedAtLessThanEqual(LocalDateTime date);
    List<User> findByIdAfter(Long id);
    List<User> findByIdBetween(Long id1, Long id2);
    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    // select with nullCheck
    List<User> findByIdIsNotNull();
    List<User> findByNameIsNotNull();

    // select with sorting
    List<User> findTopByNameOrderByIdDesc(String martin);
    List<User> findTop2ByNameOrderByIdDesc(String name);
    List<User> findByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);

    // select with paging
    Page<User> findByName(String name, Pageable pageable);
}
