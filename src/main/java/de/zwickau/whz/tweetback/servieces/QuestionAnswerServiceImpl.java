package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.QuestionAnswer;
import de.zwickau.whz.tweetback.repositories.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public QuestionAnswerServiceImpl(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @Override
    public void saveQuestionAnswer(Question question, Answer answer) {
        QuestionAnswer questionAnswer = this.questionAnswerRepository.findByAnswerAndQuestion(answer, question);
        if(questionAnswer == null){
            questionAnswer = new QuestionAnswer();
            questionAnswer.setQuestion(question);
            questionAnswer.setAnswer(answer);
        }
        questionAnswer.setCount(questionAnswer.getCount() + 1);
        this.questionAnswerRepository.save(questionAnswer);
    }
}
