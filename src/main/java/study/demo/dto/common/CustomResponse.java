package study.demo.dto.common;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private int status;
    private String message;
    private Object data;

}
