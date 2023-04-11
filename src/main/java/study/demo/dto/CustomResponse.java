package study.demo.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private int status;
    private Object data;

}
