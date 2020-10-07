package com.epam.tasks.sixth.data.exceptions;

public class BookDeletionException extends Exception {
    public BookDeletionException() {
    }

    public BookDeletionException(String message) {
        super(message);
    }

    public BookDeletionException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDeletionException(Throwable cause) {
        super(cause);
    }
}
