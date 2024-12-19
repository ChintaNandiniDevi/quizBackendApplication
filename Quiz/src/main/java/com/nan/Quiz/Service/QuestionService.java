package com.nan.Quiz.Service;

import com.nan.Quiz.DAO.QuestionDAO;
import com.nan.Quiz.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public ResponseEntity<String> insertQuestion(Question question) {
         questionDAO.save(question);
         return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public Optional<Question> updateQuestion(Question question, int id) {
        Optional<Question> tempQuestion = questionDAO.findById(id);
        if(tempQuestion.isPresent()) {
            tempQuestion.get().setCategory("py");
        }
        questionDAO.save(tempQuestion.get());
        return tempQuestion;
//        return "updates Succesfully";
    }
}
