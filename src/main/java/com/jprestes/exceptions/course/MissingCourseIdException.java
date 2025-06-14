package com.jprestes.exceptions.course;

public class MissingCourseIdException extends RuntimeException {
    public MissingCourseIdException(String message) {
        super(message);
    }
}
