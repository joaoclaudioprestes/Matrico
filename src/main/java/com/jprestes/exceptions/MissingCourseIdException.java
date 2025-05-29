package com.jprestes.exceptions;

public class MissingCourseIdException extends RuntimeException {
    public MissingCourseIdException(String message) {
        super(message);
    }
}
