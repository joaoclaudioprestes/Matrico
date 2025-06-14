package com.jprestes.exceptions.course;

public class InvalidCourseException extends RuntimeException {
    public InvalidCourseException(String message) {
        super(message);
    }
}
