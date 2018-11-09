package de.zwickau.whz.tweetback.repositories;

import de.zwickau.whz.tweetback.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
