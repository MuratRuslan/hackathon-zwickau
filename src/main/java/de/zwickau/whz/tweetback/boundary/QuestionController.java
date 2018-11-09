package de.zwickau.whz.tweetback.boundary;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/quiz/{sessionId}/savequestion")
    public String saveQuestion(@RequestParam String question, @PathVariable String  sessionId) {
        questionService.save(question);
        return "redirect:/quiz/{sessionId}";
    }
}
