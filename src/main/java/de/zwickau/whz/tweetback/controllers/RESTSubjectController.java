package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.servieces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTSubjectController {

    private final SubjectService subjectService;

    @Autowired
    public RESTSubjectController(SubjectService quizService) {
        this.subjectService = quizService;
    }

    @GetMapping("/api/quizzes/{id}")
    public Subject getOneQuiz(@PathVariable Long id){
        return this.subjectService.getById(id);
    }

    @GetMapping("/api/quizzes")
    public List<Subject> getAllQuizzes(){
        return this.subjectService.getAll();
    }
}
