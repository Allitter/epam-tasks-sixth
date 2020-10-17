package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;

import java.util.Comparator;

public class GenreComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstBookGenre = firstBook.getGenre();
        String secondBookGenre = secondBook.getGenre();
        return firstBookGenre.compareTo(secondBookGenre);
    }
}
