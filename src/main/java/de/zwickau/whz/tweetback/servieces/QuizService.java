package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Quiz;

import java.util.List;

public interface QuizService {

    Quiz getById(Long id);

    List<Quiz> getAll();
}
