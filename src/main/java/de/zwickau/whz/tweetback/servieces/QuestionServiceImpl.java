package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.dtos.QuestionDto;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The question with ID=%d is not found", id)));
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

    @Override
    public void saveQuestion(QuestionDto questionDto) {
        Question question = new Question(questionDto.getQuestion());
//        question.setAnswers(List.of(
//                new Answer(questionDto.getAnswer1()),
//                new Answer(questionDto.getAnswer2()),
//                new Answer(questionDto.getAnswer3()),
//                new Answer(questionDto.getAnswer4())
//        ));
    }
}
