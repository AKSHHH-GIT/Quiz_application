package com.verto.demo.service;

import java.util.List;

import com.verto.demo.model.Question;
import com.verto.demo.model.Quiz;
import com.verto.demo.model.UserAnswer;

public interface IQuizService {

    Quiz createQuiz(String title);

    Quiz addQuestionToQuiz(Long quizId, Long questionId);

    List<Quiz> getAllQuizzes();

    List<Question> getQuizQuestions(Long quizId);

    int calculateScore(Long quizId, List<UserAnswer> answers);
}
