package de.zwickau.whz.tweetback.repositories;

import de.zwickau.whz.tweetback.domain.Lecture;
import de.zwickau.whz.tweetback.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllBySubject(Subject subject);
}
