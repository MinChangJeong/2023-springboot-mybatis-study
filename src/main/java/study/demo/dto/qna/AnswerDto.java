package study.demo.dto.qna;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private int questionId;
    private String content;
    private String writerId;
    private String createdAt;
    private String updatedAt;
}
