package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;

import java.util.List;

public interface AnswerService {

    Answer getById(Long id);

    List<Answer> getAll();
}
