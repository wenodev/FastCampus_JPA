package com.example.FastJpa.apractice.onetomanyunidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
