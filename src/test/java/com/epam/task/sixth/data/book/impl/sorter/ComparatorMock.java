package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.model.Book;
import java.util.Comparator;

/**
 * always returns -1
 * */
public class ComparatorMock implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        return -1;
    }
}
