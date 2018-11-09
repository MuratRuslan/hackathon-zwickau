package de.zwickau.whz.tweetback.config;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.repositories.AnswerRepository;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import de.zwickau.whz.tweetback.repositories.SubjectRepository;
import de.zwickau.whz.tweetback.servieces.AnswerService;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import de.zwickau.whz.tweetback.servieces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DbConfig {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private SubjectRepository subjectRepository;

    @Autowired
    public DbConfig(QuestionRepository questionRepository,
                    AnswerRepository answerRepository,
                    SubjectRepository subjectRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    public void init() {
        Subject subject = new Subject();
        subject.setName("subject 1");

        Question question = new Question();
        question.setText("text1");
        question.setSubject(subject);

        Answer answer1 = new Answer();
        answer1.setText("answer 1");
        answer1.getQuestions().add(question);


        Answer answer2 = new Answer();
        answer2.setText("answer 2");
        answer2.getQuestions().add(question);


        Answer answer3 = new Answer();
        answer3.setText("answer 3");
        answer3.getQuestions().add(question);


        Answer answer4 = new Answer();
        answer4.setText("answer 4");
        answer4.getQuestions().add(question);

        this.subjectRepository.save(subject);
        this.questionRepository.save(question);
        this.answerRepository.save(answer1);
        this.answerRepository.save(answer2);
        this.answerRepository.save(answer3);
        this.answerRepository.save(answer4);
    }
}
