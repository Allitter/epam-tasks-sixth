package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;

import java.util.ArrayList;
import java.util.List;

public class GenreBookSpecification implements BookSpecification {
    private final BookGenre specifiedGenre;

    public GenreBookSpecification(String genre) {
        genre = genre.toUpperCase();
        this.specifiedGenre = BookGenre.valueOf(genre);
    }

    @Override
    public List<Book> find(List<Book> books) {
        List<Book> result = new ArrayList<>();
        BookGenre genre;
        for (Book book : books) {
            genre = book.getGenre();
            if (genre.equals(specifiedGenre)) {
                result.add(book);
            }
        }
        return result;
    }
}
