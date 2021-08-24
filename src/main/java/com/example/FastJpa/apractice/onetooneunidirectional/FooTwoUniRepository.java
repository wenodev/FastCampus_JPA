package com.example.FastJpa.apractice.onetooneunidirectional;

import com.example.FastJpa.apractice.onetooneunidirectional.FooTwoUni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooTwoUniRepository extends JpaRepository<FooTwoUni, Long> {
}
