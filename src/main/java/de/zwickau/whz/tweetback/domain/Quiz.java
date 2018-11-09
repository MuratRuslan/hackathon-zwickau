package de.zwickau.whz.tweetback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "quiz")
@Data
public class Quiz extends BaseEntity {

    @OneToMany(mappedBy = "question")
    private List<Question> questions;
}
