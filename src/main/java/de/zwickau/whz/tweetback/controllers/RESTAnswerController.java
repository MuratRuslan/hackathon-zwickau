package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Answer;
import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.dtos.AnswerDTO;
import de.zwickau.whz.tweetback.servieces.AnswerService;
import de.zwickau.whz.tweetback.servieces.QuestionAnswerService;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTAnswerController {

    private AnswerService answerService;
    private QuestionService questionService;
    private QuestionAnswerService questionAnswerService;

    @Autowired
    public RESTAnswerController(AnswerService answerService,
                                QuestionService questionService,
                                QuestionAnswerService questionAnswerService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.questionAnswerService = questionAnswerService;
    }

    @PostMapping("/api/answers/choose")
    @ResponseBody
    public ResponseEntity<String> chooseAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = this.answerService.getById(answerDTO.getAnswerId());
        Question question = this.questionService.getById(answerDTO.getQuestionId());
        this.questionAnswerService.saveQuestionAnswer(question, answer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>("SUCCES", headers, HttpStatus.OK);
    }
}
