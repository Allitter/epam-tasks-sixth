package com.epam.tasks.sixth.data.book.specifications;

import com.epam.tasks.sixth.model.Book;

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
