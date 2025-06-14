package com.jprestes.exceptions.student;

public class InvalidStudentException extends RuntimeException {
    public InvalidStudentException(String message) {
        super(message);
    }
}
