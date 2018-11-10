package de.zwickau.whz.tweetback.boundary;

import de.zwickau.whz.tweetback.servieces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    private SubjectService subjectService;

    @Autowired
    public QuizController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/quiz/{sessionId}", method = RequestMethod.GET)
    public String watch(@PathVariable String sessionId, Model model) {
        model.addAttribute("questions", subjectService.getAll());
        model.addAttribute("sessionId", sessionId);
        return "quiz";
    }
}
