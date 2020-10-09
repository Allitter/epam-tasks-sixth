package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

public class AuthorBookSpecification implements BookSpecification {
    private final String author;

    public AuthorBookSpecification(String author) {
        this.author = author;
    }

    public boolean specified(Book book) {
        String toCompare = book.getAuthor();
        return toCompare.equals(author);
    }
}
