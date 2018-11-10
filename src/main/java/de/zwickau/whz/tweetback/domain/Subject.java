package de.zwickau.whz.tweetback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
public class Subject extends BaseEntity {

    @JoinColumn(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Question> questions = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }
}
