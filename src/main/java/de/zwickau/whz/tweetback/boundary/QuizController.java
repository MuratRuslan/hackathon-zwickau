package de.zwickau.whz.tweetback.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    @RequestMapping(value = "/{sessionId}/quiz", method = RequestMethod.GET)
    public String watch(@PathVariable String sessionId) {
        return "sdlk";
    }
}
