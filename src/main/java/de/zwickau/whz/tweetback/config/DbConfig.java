package de.zwickau.whz.tweetback.config;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import de.zwickau.whz.tweetback.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DbConfig {


    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;

    @Autowired
    public DbConfig(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @PostConstruct
    public void init() {

    }
}
