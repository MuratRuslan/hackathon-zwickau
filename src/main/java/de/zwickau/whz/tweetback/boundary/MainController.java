package de.zwickau.whz.tweetback.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/createsession")
    public String createSession(Model model) {
        String sessionId = "kfje";
//        ModelAndView modelAndView = new ModelAndView("redirect:session");
//        modelAndView.addObject("sessionId", sessionId);
        model.addAttribute("sessionId", sessionId);
        return "session";
    }


}
