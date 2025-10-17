package com.verto.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

// Represents user's answer submission for a question
@Getter
@Setter
public class UserAnswer {
    private Long questionId;              // ID of the question
    private List<String> selectedAnswers; // Answers selected by the user
}
