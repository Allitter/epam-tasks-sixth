package com.epam.tasks.sixth.data.exceptions;

public class UnknownBookSpecificationException extends Exception {
    public UnknownBookSpecificationException() {
    }

    public UnknownBookSpecificationException(String message) {
        super(message);
    }

    public UnknownBookSpecificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownBookSpecificationException(Throwable cause) {
        super(cause);
    }
}
