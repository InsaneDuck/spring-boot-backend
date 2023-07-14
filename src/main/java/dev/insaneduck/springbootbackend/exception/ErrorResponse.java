package dev.insaneduck.springbootbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errorMessage;
}

