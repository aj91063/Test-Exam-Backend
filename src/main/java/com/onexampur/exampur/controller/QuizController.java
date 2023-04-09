package com.onexampur.exampur.controller;

import com.onexampur.exampur.model.Quize.Quize;
import com.onexampur.exampur.repository.QuizRepository;
import com.onexampur.exampur.servises.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /* Add Quiz */
    @PostMapping("/addQuiz")
    public ResponseEntity<?> addQuiz( @RequestBody Quize quize){

        final Quize saveQuiz = this.quizService.addQuize(quize);
        return ResponseEntity.ok(saveQuiz);

    }

    /* Get all Quizzes */
    @GetMapping("/getAllQuizzes")
    public ResponseEntity<?> getAllQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    /* Get single Quiz */
    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable(value = "quizId", required = true) Long quizId){
        return ResponseEntity.ok(this.quizService.getQuiz(quizId));
    }

    /* Update The Quiz */
    @PutMapping("/updateQuiz")
    public ResponseEntity<?> updateQuiz(@RequestBody Quize quize){
        return ResponseEntity.ok(this.quizService.updateQuiz(quize));
    }

    /* Delete Quiz By Id */
    @DeleteMapping("/deleteQuiz/{quizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable(value = "quizId", required = true) Long quizId){
        this.quizService.deleteQuiz(quizId);
        return ResponseEntity.ok("quiz is delete successfully");
    }




}
