package com.nan.Quiz.DAO;

import com.nan.Quiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
