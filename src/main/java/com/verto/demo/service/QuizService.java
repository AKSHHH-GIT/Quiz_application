package com.verto.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verto.demo.model.Question;
import com.verto.demo.model.Quiz;
import com.verto.demo.model.UserAnswer;
import com.verto.demo.repository.QuestionRepository;
import com.verto.demo.repository.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // Create a new quiz with validated question IDs
    public Quiz createQuiz(Quiz quiz) {
        List<Question> validQuestions = new ArrayList<>();

        // Fetch questions from database using IDs
        for (Question q : quiz.getQuestions()) {
            questionRepository.findById(q.getId()).ifPresent(validQuestions::add);
        }

        quiz.setQuestions(validQuestions);
        return quizRepository.save(quiz);
    }

    //  Get all quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    //  Get a quiz by ID
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    //  Save a question to database
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    //Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    //  Get all questions of a specific quiz (hide correct answers)
    public List<Question> getQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<Question> questions = quiz.getQuestions();

        // Remove correct answers before returning
        questions.forEach(q -> q.setCorrectAnswers(null));
        return questions;
    }

    //  Calculate score for submitted answers
    public int calculateScore(Long quizId, List<UserAnswer> userAnswers) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        int score = 0;

        for (UserAnswer userAnswer : userAnswers) {
            Optional<Question> questionOpt = quiz.getQuestions().stream()
                    .filter(q -> q.getId().equals(userAnswer.getQuestionId()))
                    .findFirst();

            if (questionOpt.isPresent()) {
                Question question = questionOpt.get();

                // Compare answers (order-independent)
                if (question.getCorrectAnswers().size() == userAnswer.getSelectedAnswers().size()
                        && question.getCorrectAnswers().containsAll(userAnswer.getSelectedAnswers())) {
                    score++;
                }
            }
        }

        return score;
    }
}
