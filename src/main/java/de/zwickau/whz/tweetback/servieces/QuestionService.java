package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;

import java.util.List;

public interface QuestionService {

    Question getById(Long id);

    List<Question> getAllQuestions();

    List<Question> getAllBySubject(Subject subject);

    void saveQuestion(Question question);
}
