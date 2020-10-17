package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;

import java.util.Comparator;

public class GenreComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        BookGenre firstBookGenre = firstBook.getGenre();
        BookGenre secondBookGenre = secondBook.getGenre();
        return firstBookGenre.compareTo(secondBookGenre);
    }
}
