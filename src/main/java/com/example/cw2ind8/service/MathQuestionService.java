package com.example.cw2ind8.service;

import com.example.cw2ind8.exception.MethodNotAllowedException;
import com.example.cw2ind8.model.Question;
import com.example.cw2ind8.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Добавление запрещено");
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException("Добавление запрещено");
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException("Удаление запрещено");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Получение вопросов запрещено");
    }

    @Override
    public Question getRandomQuestion() {
        String randomQuestion = UUID.randomUUID().toString();
        String randomAnswer = new StringBuilder(randomQuestion).reverse().toString();
        return new Question(randomQuestion, randomAnswer);
    }
}
