package com.verto.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.verto.demo.model.Question;

public interface IQuestionService {
    //new question
    Question createQuestion(Question question);
    // all questions
    List<Question> getAllQuestions();
    // get question by id
    Optional<Question> getQuestionById (Long id);
    // all subjects
    List<String> getAllSubjects();
    // update q by id
    Question updateQuestion(Long id, Question question) throws NotFoundException;
    // delete q by id
    void deleteQuestion(Long id);
    
    List <Question> getQuestionsForUser(Integer numOfQuestions, String subjects);
    
}
