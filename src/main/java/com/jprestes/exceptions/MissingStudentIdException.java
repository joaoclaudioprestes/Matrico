package com.jprestes.exceptions;

public class MissingStudentIdException extends RuntimeException {
    public MissingStudentIdException(String message) {
        super(message);
    }
}
