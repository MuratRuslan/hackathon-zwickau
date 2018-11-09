package de.zwickau.whz.tweetback.repositories;

import de.zwickau.whz.tweetback.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long> {

}
