package com.onexampur.exampur.servises;

import com.onexampur.exampur.model.Quize.Question;
import com.onexampur.exampur.model.Quize.Quize;

import java.util.Set;

public interface QuestionService {

    Question addQuestion(Question question);
    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long questionId);

    void deleteQuestion(Long questionId);

    Set<Question> getQuestionOfQuiz(Quize quize);


}
