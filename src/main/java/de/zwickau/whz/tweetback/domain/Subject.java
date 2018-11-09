package de.zwickau.whz.tweetback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
public class Subject extends BaseEntity {

    @JoinColumn(name = "name")
    private String name;
//Kalys petuh
    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Question> questions = new ArrayList<>();
}
