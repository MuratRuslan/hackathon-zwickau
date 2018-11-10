package de.zwickau.whz.tweetback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lectures")
public class Lecture extends BaseEntity{

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "theme")
    private String theme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
