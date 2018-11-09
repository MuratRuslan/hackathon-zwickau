package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject getById(Long id) {
        Subject subject = this.subjectRepository.getOne(id);
        if (subject != null) {
            return subject;
        } else {
            throw new RuntimeException(String.format("The subject with ID=%d is not found", id));
        }
    }

    @Override
    public List<Subject> getAll() {
        return this.subjectRepository.findAll();
    }

    @Override
    public void saveSubject(Subject subject) {
        this.subjectRepository.save(subject);
    }
}
