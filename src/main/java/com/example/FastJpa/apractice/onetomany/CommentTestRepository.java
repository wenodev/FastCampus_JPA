package com.example.FastJpa.apractice.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentTestRepository extends JpaRepository<CommentTest, Long> {
}
