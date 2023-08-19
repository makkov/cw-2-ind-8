package com.example.cw2ind8.service;

import com.example.cw2ind8.exception.IncorrectQuestionCountException;
import com.example.cw2ind8.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService
    ) {
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> questions = new HashSet<>();

        Random random = new Random();

        while (questions.size() < amount) {
            int questionServiceIdx = random.nextInt(questionServices.size());
            questions.add(questionServices.get(questionServiceIdx).getRandomQuestion());
        }

        return questions;
    }
}
