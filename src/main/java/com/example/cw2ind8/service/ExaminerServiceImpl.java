package com.example.cw2ind8.service;

import com.example.cw2ind8.exception.IncorrectQuestionCountException;
import com.example.cw2ind8.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        int countQuestions = questionService.getAll().size();
        if (countQuestions < amount) {
            throw new IncorrectQuestionCountException(String.format("Запрошено %s, всего вопросов %s", amount, countQuestions));
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
