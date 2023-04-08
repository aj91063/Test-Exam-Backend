package com.onexampur.exampur.servises.serviceImpl;

import com.onexampur.exampur.model.Quize.Question;
import com.onexampur.exampur.model.Quize.Quize;
import com.onexampur.exampur.repository.QuestionRepository;
import com.onexampur.exampur.servises.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.Set;

public  class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question) ;
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question =new Question();
        question.setQuesId(questionId);
       this.questionRepository.delete(question);
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quize quize) {
        return this.questionRepository.findByQuize(quize);
    }
}
