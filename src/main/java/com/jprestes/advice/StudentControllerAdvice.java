package com.jprestes.advice;

import com.jprestes.domain.dto.ApiErrorDTO;
import com.jprestes.exceptions.student.InvalidStudentException;
import com.jprestes.exceptions.student.MissingStudentIdException;
import com.jprestes.exceptions.student.StudentNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerAdvice {
    @ExceptionHandler(InvalidStudentException.class)
    public ResponseEntity<ApiErrorDTO> handleValidationException(InvalidStudentException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MissingStudentIdException.class)
    public ResponseEntity<ApiErrorDTO> handleIdRequiredException(MissingStudentIdException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleNotFoundException(StudentNotFoundException exception, HttpServletRequest request) {
        ApiErrorDTO error = new ApiErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
