package com.onexampur.exampur.controller;


import com.onexampur.exampur.model.Quize.Question;
import com.onexampur.exampur.model.Quize.Quize;
import com.onexampur.exampur.servises.QuestionService;
import com.onexampur.exampur.servises.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    /* Add Question */
    @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    /* Get all question */
    @GetMapping("/")
    public ResponseEntity<?> getAllQuestions(){
            return ResponseEntity.ok(this.questionService.getQuestions());
    }

    /* Get single Question */
    @GetMapping("/{quesId}")
    public ResponseEntity<?> getQuestion(@PathVariable(value = "quesId", required = true) Long quesId){
        return ResponseEntity.ok(this.questionService.getQuestion(quesId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable(value = "quizId", required = true) Long quizId){
//        Quize quize =new Quize();
//        quize.setqId(quizId);
//        final Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quize);
//        return ResponseEntity.ok(questionOfQuiz);

         Quize quiz = this.quizService.getQuiz(quizId);
         Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    /* Update Question */
    @PutMapping("/updateQuestion")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    /* Delete Question */
    @DeleteMapping("/deleteQuestion/{quesId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable(value = "quesId", required = true) Long quesId){
        this.questionService.deleteQuestion(quesId);
        return ResponseEntity.ok("Question deleted successfully");
    }








}
