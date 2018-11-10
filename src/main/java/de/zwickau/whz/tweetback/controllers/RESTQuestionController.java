package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.dtos.QuestionDto;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import de.zwickau.whz.tweetback.servieces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class RESTQuestionController {

    private final QuestionService questionService;
    private final SubjectService subjectService;

    @Autowired
    public RESTQuestionController(QuestionService questionService,
                                  SubjectService subjectService) {
        this.questionService = questionService;
        this.subjectService = subjectService;
    }

    @GetMapping("/api/questions/{id}")
    public Question getOneQuestion(@PathVariable Long id){
        return this.questionService.getById(id);
    }

    @GetMapping("/api/questions/bySubject/{subjectId}")
    public Question getAllQuestions(@PathVariable Long subjectId){
        Subject subject = this.subjectService.getById(subjectId);
        return this.questionService.getAllBySubject(subject)
                .stream()
                .max(Comparator.comparing(Question::getDate))
                .orElseThrow(() -> new RuntimeException(String.format("There is no question in subject ID=%d", subjectId)));
    }
}
