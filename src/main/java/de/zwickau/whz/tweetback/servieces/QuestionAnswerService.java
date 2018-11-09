package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Question;

public interface QuestionAnswerService {

    void saveQuestionAnswer(Question question, Answer answer);
}
