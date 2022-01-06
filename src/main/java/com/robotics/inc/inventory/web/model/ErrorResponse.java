package com.robotics.inc.inventory.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private HttpStatus httpStatusCode;
    private String errorMessage;
}
