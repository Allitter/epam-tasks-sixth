package com.epam.tasks.sixth.data.book.specification;

import com.epam.tasks.sixth.model.Book;

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
