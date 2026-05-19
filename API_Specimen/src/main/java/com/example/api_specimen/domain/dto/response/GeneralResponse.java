package com.example.api_specimen.domain.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse {
    private String uri;
    private String message;
    private int status;
    private LocalDateTime time;
    private Object data;
}
