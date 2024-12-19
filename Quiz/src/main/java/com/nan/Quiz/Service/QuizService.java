package com.nan.Quiz.Service;

import com.nan.Quiz.DAO.QuestionDAO;
import com.nan.Quiz.DAO.QuizDAO;
import com.nan.Quiz.Entity.Answers;
import com.nan.Quiz.Entity.Question;
import com.nan.Quiz.Entity.QuestionWrapper;
import com.nan.Quiz.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public Quiz createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDAO.findQuestionBYCategoryWithnum(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestion(questions);
        quizDAO.save(quiz);
        return quiz;
    }


    public List<QuestionWrapper> getQuizById(Integer id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q: questionFromDB) {
            QuestionWrapper qa = new QuestionWrapper(q.getId(), q.getOption1(), q.getOption2(), q.getOption3(), q.getQuestionTitle());
            questionForUser.add(qa);
        }
        return questionForUser;
    }



    public Integer getResult(Integer id, List<Answers> answers) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questions = quiz.get().getQuestion();

        int i = 0;
        int right = 0;
        for(Answers answer: answers) {
            if(answer.getAnswer().equals(questions.get(i).getRightAnswer()))
                right++;
        }
        i++;
        return right;
    }
}
