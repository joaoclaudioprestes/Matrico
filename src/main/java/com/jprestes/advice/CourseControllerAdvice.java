package com.jprestes.advice;

import com.jprestes.domain.dto.ApiErrorDTO;
import com.jprestes.exceptions.MissingCourseIdException;
import com.jprestes.exceptions.CourseNotFoundException;
import com.jprestes.exceptions.InvalidCourseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseControllerAdvice {

    @ExceptionHandler(InvalidCourseException.class)
    public ResponseEntity<ApiErrorDTO> handleValidationException(InvalidCourseException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MissingCourseIdException.class)
    public ResponseEntity<ApiErrorDTO> handleIdRequiredException(MissingCourseIdException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleNotFoundException(CourseNotFoundException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
