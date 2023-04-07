package com.onexampur.exampur.repository;

import com.onexampur.exampur.model.Quize.Quize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quize, Long> {
}
