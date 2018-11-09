package de.zwickau.whz.tweetback.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/questionnaire")
public class QuestionnaireController {



    @PostMapping
    public String createQuestionnaire(){
        return "questionnaire";
    }
}
