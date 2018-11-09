package de.zwickau.whz.tweetback.dtos;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long questionId;
    private Long answerId;
}
