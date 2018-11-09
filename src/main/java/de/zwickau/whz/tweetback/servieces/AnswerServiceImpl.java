package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer getById(Long id) {
        Answer answer = this.answerRepository.getOne(id);
        if (answer != null) {
            return answer;
        } else {
            throw new RuntimeException(String.format("The answer with ID=%d is not found", id));
        }
    }

    @Override
    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public void saveAnswer(Answer answer) {
        this.answerRepository.save(answer);
    }
}
