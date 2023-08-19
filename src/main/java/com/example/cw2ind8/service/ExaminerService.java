package com.example.cw2ind8.service;

import com.example.cw2ind8.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
