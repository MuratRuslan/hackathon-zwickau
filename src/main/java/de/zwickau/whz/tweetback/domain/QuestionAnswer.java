package de.zwickau.whz.tweetback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "choose_answers")
public class QuestionAnswer extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "question_id", unique = true)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id", unique = true)
    private Answer answer;

    @JoinColumn(name = "count")
    private Integer count = 0;
}
