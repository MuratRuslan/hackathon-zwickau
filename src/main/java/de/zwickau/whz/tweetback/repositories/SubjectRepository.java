package de.zwickau.whz.tweetback.repositories;

import de.zwickau.whz.tweetback.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
