package de.zwickau.whz.tweetback.domain;

import de.zwickau.whz.tweetback.domain.enums.Answer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "question")
@Data
public class Question extends BaseEntity {


    private String string;

    @Enumerated(EnumType.STRING)
    private Answer answer;
}
