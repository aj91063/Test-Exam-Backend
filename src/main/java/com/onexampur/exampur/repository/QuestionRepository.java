package com.onexampur.exampur.repository;

import com.onexampur.exampur.model.Quize.Question;
import com.onexampur.exampur.model.Quize.Quize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuize(Quize quize);
}
