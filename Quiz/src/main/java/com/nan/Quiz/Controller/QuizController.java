package com.nan.Quiz.Controller;

import com.nan.Quiz.Entity.Answers;
import com.nan.Quiz.Entity.QuestionWrapper;
import com.nan.Quiz.Entity.Quiz;
import com.nan.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public Quiz createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
         return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/getQuiz/{id}")
    public List<QuestionWrapper> getQuizById(@PathVariable Integer id) {
        return quizService.getQuizById(id);
    }

    @GetMapping("result/{id}")
    public Integer getResult(@PathVariable Integer id, @RequestBody List<Answers> answers) {
       return quizService.getResult(id, answers);
    }
}
