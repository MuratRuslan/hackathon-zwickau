package de.zwickau.whz.tweetback.boundary;

import de.zwickau.whz.tweetback.dtos.QuestionDto;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(value = "/quiz/{sessionId}/savequestion")
    public String saveQuestion(@ModelAttribute QuestionDto questionDto, @PathVariable String  sessionId) {
        questionService.saveQuestion(questionDto);
        return "redirect:/quiz/{sessionId}";
    }
}
