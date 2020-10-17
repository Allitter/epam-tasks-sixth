package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;

public class GenreBookSpecification implements BookSpecification {
    private final BookGenre genre;

    public GenreBookSpecification(String genre) {
        genre = genre.toUpperCase();
        this.genre = BookGenre.valueOf(genre);
    }

    public boolean specified(Book book) {
        BookGenre toCompare = book.getGenre();
        return toCompare.equals(genre);
    }
}
