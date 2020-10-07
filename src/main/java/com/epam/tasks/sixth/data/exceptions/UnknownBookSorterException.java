package com.epam.tasks.sixth.data.exceptions;

public class UnknownBookSorterException extends Exception {
    public UnknownBookSorterException() {
    }

    public UnknownBookSorterException(String message) {
        super(message);
    }

    public UnknownBookSorterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownBookSorterException(Throwable cause) {
        super(cause);
    }
}
