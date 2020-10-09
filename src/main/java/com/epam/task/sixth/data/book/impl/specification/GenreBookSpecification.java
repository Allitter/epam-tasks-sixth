package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

public class GenreBookSpecification implements BookSpecification {
    private final String genre;

    public GenreBookSpecification(String genre) {
        this.genre = genre;
    }

    public boolean specified(Book book) {
        String toCompare = book.getGenre();
        return toCompare.equals(genre);
    }
}
