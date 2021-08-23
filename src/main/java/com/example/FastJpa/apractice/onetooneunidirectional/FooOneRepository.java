package com.example.FastJpa.apractice.onetooneunidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FooOneRepository extends JpaRepository<FooOne, Long> {
}
