package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;

import java.util.Comparator;

public class IdComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookId = firstBook.getId();
        int secondBookId = secondBook.getId();
        return Integer.compare(firstBookId, secondBookId);
    }
}
