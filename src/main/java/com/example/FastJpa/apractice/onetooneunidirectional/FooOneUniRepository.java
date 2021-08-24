package com.example.FastJpa.apractice.onetooneunidirectional;

import com.example.FastJpa.apractice.onetooneunidirectional.FooOneUni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooOneUniRepository extends JpaRepository<FooOneUni, Long> {
}
