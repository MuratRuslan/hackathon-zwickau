package de.zwickau.whz.tweetback.boundary;

import de.zwickau.whz.tweetback.domain.Question;
import de.zwickau.whz.tweetback.domain.enums.AnswerType;
import de.zwickau.whz.tweetback.repositories.QuestionRepository;
import de.zwickau.whz.tweetback.servieces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
public class QuestionnaireController {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionnaireController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

//    @PostMapping("/questionnaire")
//    public String createQuestionnaire(Model model){
//        List<Question> all = questionRepository.findAll();
//        model.addAttribute("questions", all);
//        return "questionnaire";
//    }
//
//    @GetMapping("/questionnaire")
//    public String getQuestionnaire(Model model) {
//        List<Question> all = questionRepository.findAll();
//        model.addAttribute("questions", all);
//        return "questionnaire";
//    }
//
//    @PostMapping("/questionnaire/add")
//    public String addQuestion(@RequestParam String question) {
//
//        questionRepository.save(new Question(question, new ArrayList(EnumSet.allOf(AnswerType.class))));
//        return "redirect:/questionnaire";
//    }
}
