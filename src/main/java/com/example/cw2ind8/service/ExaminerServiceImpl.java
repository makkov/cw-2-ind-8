package com.example.cw2ind8.service;

import com.example.cw2ind8.exception.IncorrectQuestionCountException;
import com.example.cw2ind8.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices = new ArrayList<>();
    private final Random random;

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService,
            Random random
    ) {
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            int questionServiceIdx = random.nextInt(questionServices.size());
            questions.add(questionServices.get(questionServiceIdx).getRandomQuestion());
        }

        return questions;
    }
}
