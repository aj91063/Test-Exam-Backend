package com.onexampur.exampur.repository;

import com.onexampur.exampur.model.Quize.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
