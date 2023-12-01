package org.kentiki.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kentiki.domain.Img;
import org.kentiki.model.Answer;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDto {
    private int day;
    private int month;
    private int year;

    public static AnswerDto toDto(Answer answer){
        String[] date = answer.getDate().split("\\.");
        return new AnswerDto(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2]));
    }

    public static Answer toModelObject(AnswerDto answerDto){
        return new Answer(
                answerDto.day + "." +
                answerDto.month + "." +
                answerDto.year
        );
    }
}
