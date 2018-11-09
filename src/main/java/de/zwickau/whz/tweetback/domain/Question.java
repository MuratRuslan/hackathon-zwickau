package de.zwickau.whz.tweetback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    @JoinColumn(name = "text")
    private String text;

    @ManyToMany(mappedBy = "questions")
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
