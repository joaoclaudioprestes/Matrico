package com.jprestes.exceptions.student;

public class MissingStudentIdException extends RuntimeException {
    public MissingStudentIdException(String message) {
        super(message);
    }
}
