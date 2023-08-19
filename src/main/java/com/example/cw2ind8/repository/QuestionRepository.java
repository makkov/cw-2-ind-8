package com.example.cw2ind8.repository;

import com.example.cw2ind8.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
