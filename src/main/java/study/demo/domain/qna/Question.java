package study.demo.domain.qna;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question{
    private int id;
    private String title;
    private String content;
    private String writerId;
    private String createdAt;
    private String updatedAt;
}