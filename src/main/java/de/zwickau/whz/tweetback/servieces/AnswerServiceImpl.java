package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.repositories.AnswerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return this.answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The answer with ID=%d is not found", id)));
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
