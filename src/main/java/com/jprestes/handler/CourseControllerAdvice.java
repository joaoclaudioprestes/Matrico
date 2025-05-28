package com.jprestes.handler;

import com.jprestes.exceptions.CourseValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseControllerAdvice {

    @ExceptionHandler(CourseValidationException.class)
    private ResponseEntity<RestErrorMessage> handleValidationException(CourseValidationException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
