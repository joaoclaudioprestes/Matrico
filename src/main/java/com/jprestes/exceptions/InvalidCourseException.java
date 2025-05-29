package com.jprestes.exceptions;

public class InvalidCourseException extends RuntimeException {
    public InvalidCourseException(String message) {
        super(message);
    }
}
