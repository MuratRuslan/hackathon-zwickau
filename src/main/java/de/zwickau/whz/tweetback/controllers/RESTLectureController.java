package de.zwickau.whz.tweetback.controllers;

import de.zwickau.whz.tweetback.domain.Lecture;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.servieces.LectureService;
import de.zwickau.whz.tweetback.servieces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTLectureController {

    private SubjectService subjectService;
    private LectureService lectureService;

    @Autowired
    public RESTLectureController(SubjectService subjectService,
                                 LectureService lectureService) {
        this.subjectService = subjectService;
        this.lectureService = lectureService;
    }

    @GetMapping("/api/lectures/{subjectId}")
    public List<Lecture> getAllBySubject(@PathVariable Long subjectId){
        Subject subject = this.subjectService.getById(subjectId);
        return this.lectureService.getAllBySubject(subject);
    }
}
