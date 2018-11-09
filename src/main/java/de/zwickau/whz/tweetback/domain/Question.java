package de.zwickau.whz.tweetback.domain;

import de.zwickau.whz.tweetback.domain.enums.AnswerType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question extends BaseEntity {

    private String text;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "answers")
    @JoinTable(name = "questions_answers",
            joinColumns = {@JoinColumn(name = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "answer_id")})
    private List<AnswerType> answers;
}
