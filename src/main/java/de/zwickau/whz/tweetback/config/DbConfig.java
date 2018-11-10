package de.zwickau.whz.tweetback.config;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Lecture;
import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.repositories.AnswerRepository;
import de.zwickau.whz.tweetback.repositories.LectureRepository;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import de.zwickau.whz.tweetback.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
public class DbConfig {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private SubjectRepository subjectRepository;
    private LectureRepository lectureRepository;

    @Autowired
    public DbConfig(QuestionRepository questionRepository,
                    AnswerRepository answerRepository,
                    SubjectRepository subjectRepository,
                    LectureRepository lectureRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.subjectRepository = subjectRepository;
        this.lectureRepository = lectureRepository;
    }

    @PostConstruct
    public void init() {
        Subject subject = new Subject();
        subject.setName("subject 1");

        Subject subject2 = new Subject();
        subject2.setName("subject 2");

        Subject subject3 = new Subject();
        subject3.setName("subject 3");

        Question question = new Question();
        question.setText("text1");
        question.setSubject(subject);
        question.setDate(LocalDateTime.now());

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

        Lecture lecture = new Lecture();
        lecture.setName("lecture 1");
        lecture.setTheme("lecture theme 1");
        lecture.setSubject(subject);

        this.subjectRepository.save(subject);
        this.subjectRepository.save(subject2);
        this.subjectRepository.save(subject3);

        this.questionRepository.save(question);

        this.answerRepository.save(answer1);
        this.answerRepository.save(answer2);
        this.answerRepository.save(answer3);
        this.answerRepository.save(answer4);
        this.lectureRepository.save(lecture);
    }
}
