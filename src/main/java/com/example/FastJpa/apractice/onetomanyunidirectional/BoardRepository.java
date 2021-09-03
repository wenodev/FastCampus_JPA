package com.example.FastJpa.apractice.onetomanyunidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
