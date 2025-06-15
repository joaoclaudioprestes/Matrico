package com.jprestes.advice;

import com.jprestes.domain.dto.ApiErrorDTO;
import com.jprestes.exceptions.registration.InvalidRegistrationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegistrationControllerAdvice {

    @ExceptionHandler(InvalidRegistrationException.class)
    public ResponseEntity<ApiErrorDTO> handleValidationException(InvalidRegistrationException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
