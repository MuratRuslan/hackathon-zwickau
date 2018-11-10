package de.zwickau.whz.tweetback.servieces;

import de.zwickau.whz.tweetback.domain.Lecture;
import de.zwickau.whz.tweetback.domain.Subject;
import de.zwickau.whz.tweetback.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public List<Lecture> getAllBySubject(Subject subject) {
        return this.lectureRepository.findAllBySubject(subject);
    }

    @Override
    public Lecture getById(Long id) {
        return this.lectureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The lecture with ID=%d is not found", id)));
    }
}
