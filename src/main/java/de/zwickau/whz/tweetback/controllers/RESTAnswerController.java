package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.dtos.AnswerDTO;
import de.zwickau.whz.tweetback.servieces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTAnswerController {

    private AnswerService answerService;

    @Autowired
    public RESTAnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/api/answers/choose")
    public Answer chooseAnswer(@RequestBody AnswerDTO answerDTO){
        return null;
    }
}
