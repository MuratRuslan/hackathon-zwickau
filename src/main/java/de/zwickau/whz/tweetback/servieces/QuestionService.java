package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Question;

import java.util.List;

public interface QuestionService {

    Question getById(Long id);

    List<Question> getAllQuestions();

    void saveQuestion(Question question);
}
