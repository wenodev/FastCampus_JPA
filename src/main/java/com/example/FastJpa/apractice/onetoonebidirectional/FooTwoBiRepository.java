package com.example.FastJpa.apractice.onetoonebidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FooTwoBiRepository extends JpaRepository<FooTwoBi, Long> {
}
