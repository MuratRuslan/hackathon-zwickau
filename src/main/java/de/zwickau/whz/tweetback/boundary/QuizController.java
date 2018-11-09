package de.zwickau.whz.tweetback.boundary;

import de.zwickau.whz.tweetback.domain.Quiz;
import de.zwickau.whz.tweetback.servieces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping(value = "/quiz/{sessionId}", method = RequestMethod.GET)
    public String watch(@PathVariable String sessionId, Model model) {
        model.addAttribute("questions", quizService.getAll());
        model.addAttribute("sessionId", sessionId);
        return "quiz";
    }
}
