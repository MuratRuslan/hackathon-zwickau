package de.zwickau.whz.tweetback.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

    @GetMapping("/session")
    public String getSession(@RequestParam String sessionId, Model model) {
//        ModelAndView modelAndView = new ModelAndView("session");
//        modelAndView.addObject("sessionId", sessionId);
        model.addAttribute("sessionId", sessionId);
        return "session";
    }

    @PostMapping("/session")
    public String postSession( @RequestParam String sessionId, @RequestParam String type, Model model) {
//        ModelAndView modelAndView = new ModelAndView("redirect:" + type + "/" + sessionId);
//        modelAndView.addObject("sessionId", sessionId);
        model.addAttribute("sessionId", sessionId);
        return "redirect:"+type+"/"+sessionId;
    }
}
