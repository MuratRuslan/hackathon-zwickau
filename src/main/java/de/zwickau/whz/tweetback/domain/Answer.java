package de.zwickau.whz.tweetback.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Question> questions = new ArrayList<>();

    public Answer() {
    }

}
