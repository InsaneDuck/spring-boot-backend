package dev.insaneduck.springbootbackend.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ErrorDTO {
    private String message;
}
