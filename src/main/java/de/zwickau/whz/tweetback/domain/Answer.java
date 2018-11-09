package de.zwickau.whz.tweetback.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "questions")
    private List<Question> questions = new ArrayList<>();
}
