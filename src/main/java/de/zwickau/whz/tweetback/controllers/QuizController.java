package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Quiz;
import de.zwickau.whz.tweetback.servieces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/api/quizzes/{id}")
    public Quiz getOneQuiz(@PathVariable Long id){
        return this.quizService.getById(id);
    }

    @GetMapping("/api/quizzes")
    public List<Quiz> getAllQuizzes(){
        return this.quizService.getAll();
    }
}
