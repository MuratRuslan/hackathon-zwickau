package de.zwickau.whz.tweetback.domain;

import de.zwickau.whz.tweetback.domain.enums.AnswerType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "questions")
@NoArgsConstructor
public class Question extends BaseEntity {

    private String text;

    @ManyToMany(mappedBy = "questions")
    private List<Answer> answers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

}
