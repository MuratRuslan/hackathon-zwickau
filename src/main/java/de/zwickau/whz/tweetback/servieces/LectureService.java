package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Lecture;
import de.zwickau.whz.tweetback.domain.Subject;

import java.util.List;

public interface LectureService {

    List<Lecture> getAllBySubject(Subject subject);

    Lecture getById(Long id);

}
