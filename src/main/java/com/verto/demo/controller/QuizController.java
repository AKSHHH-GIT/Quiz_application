package com.verto.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verto.demo.model.Question;
import com.verto.demo.model.Quiz;
import com.verto.demo.model.UserAnswer;
import com.verto.demo.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //Create a new quiz with title + question IDs
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    //Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    //  Get a specific quiz by ID
    @GetMapping("/{id}")
    public Optional<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    // Add a question to the database
    @PostMapping("/question")
    public Question addQuestion(@RequestBody Question question) {
        return quizService.saveQuestion(question);
    }

    //  Get all questions from database
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    // Get all questions of a specific quiz (without correct answers)
    @GetMapping("/{quizId}/questions")
    public List<Question> getQuizQuestions(@PathVariable Long quizId) {
        return quizService.getQuizQuestions(quizId);
    }

    // Submit quiz answers and return score
    @PostMapping("/{quizId}/submit")
    public int submitQuiz(@PathVariable Long quizId, @RequestBody List<UserAnswer> userAnswers) {
        return quizService.calculateScore(quizId, userAnswers);
    }
}
