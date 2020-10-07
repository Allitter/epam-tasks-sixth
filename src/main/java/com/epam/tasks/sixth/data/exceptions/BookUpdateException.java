package com.epam.tasks.sixth.data.exceptions;

public class BookUpdateException extends Exception {
    public BookUpdateException() {
    }

    public BookUpdateException(String message) {
        super(message);
    }

    public BookUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookUpdateException(Throwable cause) {
        super(cause);
    }
}
