package de.zwickau.whz.tweetback.domain;

import de.zwickau.whz.tweetback.domain.enums.AnswerType;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AnswerType answerType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "questions_answers",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<Question> questions = new ArrayList<>();

    public Answer() {
    }

}
