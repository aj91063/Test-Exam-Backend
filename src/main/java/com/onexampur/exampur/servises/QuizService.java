package com.onexampur.exampur.servises;

import com.onexampur.exampur.model.Quize.Quize;

import java.util.Set;

public interface QuizService {

    Quize addQuize(Quize quize);

    Quize updateQuiz(Quize quize);

   Set<Quize> getQuizzes();

   Quize getQuiz(Long quizId);

   void deleteQuiz(Long quizId);
}
