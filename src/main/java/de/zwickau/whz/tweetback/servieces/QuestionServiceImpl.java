package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private SubjectService subjectService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository,
                               SubjectService subjectService) {
        this.questionRepository = questionRepository;
        this.subjectService = subjectService;
    }

    @Override
    public Question getById(Long id) {
        Question question = this.questionRepository.getOne(id);
        if (question != null) {
            return question;
        } else {
            throw new RuntimeException(String.format("The question with ID = %d is not found", id));
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public List<Question> getAllBySubject(Subject subject) {
        return this.questionRepository.findAllBySubject(subject);
    }

    @Override
    public void saveQuestion(Question question) {
        this.questionRepository.save(question);
    }
}
