package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.model.Book;
import java.util.Comparator;

/**
 * Compares books by id
 * */
public class ComparatorMock implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookId = firstBook.getId();
        int secondBookId = secondBook.getId();
        return Integer.compare(firstBookId, secondBookId);
    }
}
