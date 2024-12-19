package com.nan.Quiz.Controller;

import com.nan.Quiz.Entity.Question;
import com.nan.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return  questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(@PathVariable String category) {
        return questionService.getByCategory(category);
    }

    @PostMapping("/insertQuestion")
    public ResponseEntity<String> insertQuestion(@RequestBody Question question) {
        return questionService.insertQuestion(question);
        //return "Sucess";
    }

    @PutMapping("/updateQuestion/{id}")
    public Optional<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        return questionService.updateQuestion(question, id);
    }
}
