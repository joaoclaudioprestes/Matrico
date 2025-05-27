package com.jprestes.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponseException extends RuntimeException {
    private final HttpStatus status;

    public ErrorResponseException(String message) {
        super(message);
        this.status = null;
    }

    public ErrorResponseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
