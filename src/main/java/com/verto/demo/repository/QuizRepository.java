package com.verto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verto.demo.model.Quiz;

// Repository interface for Quiz entity
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
