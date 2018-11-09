package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Subject;

import java.util.List;

public interface SubjectService {

    Subject getById(Long id);

    List<Subject> getAll();

    void saveSubject(Subject subject);
}
