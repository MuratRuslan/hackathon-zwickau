package de.zwickau.whz.tweetback.repositories;

import de.zwickau.whz.tweetback.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
