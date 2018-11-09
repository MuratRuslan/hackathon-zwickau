package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Quiz;
import de.zwickau.whz.tweetback.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quiz = this.quizRepository.getOne(id);
        if(quiz != null){
            return quiz;
        } else {
            throw new RuntimeException(String.format("The quiz with ID=%d is not found", id));
        }
    }

    @Override
    public List<Quiz> getAll() {
        return this.quizRepository.findAll();
    }
}
