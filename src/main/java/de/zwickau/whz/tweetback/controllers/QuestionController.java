package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/questions/{id}")
    public Question getOneQuestion(@PathVariable Long id){
        return this.questionService.getById(id);
    }

    @GetMapping("/api/questions")
    public List<Question> getAllQuestions(){
        return this.questionService.getAllQuestions();
    }
}
