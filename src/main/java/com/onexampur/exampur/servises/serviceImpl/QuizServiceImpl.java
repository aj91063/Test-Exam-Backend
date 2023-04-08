package com.onexampur.exampur.servises.serviceImpl;

import com.onexampur.exampur.model.Quize.Quize;
import com.onexampur.exampur.repository.QuizRepository;
import com.onexampur.exampur.servises.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Override
    public Quize addQuize(Quize quize) {

        return  this.quizRepository.save(quize);
    }

    @Override
    public Quize updateQuiz(Quize quize) {
        return  this.quizRepository.save(quize);
    }

    @Override
    public Set<Quize> getQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quize getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quize quize = new Quize();
        quize.setqId(quizId);
        this.quizRepository.delete(quize);
    }
}
