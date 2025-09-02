package org.example.rstech.exception;

import lombok.*;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ApiError {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
