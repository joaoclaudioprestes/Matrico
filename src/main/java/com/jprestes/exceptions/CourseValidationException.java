package com.jprestes.exceptions;

public class CourseValidationException extends RuntimeException {
    public CourseValidationException(String message) {
        super(message);
    }
}
