package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.data.book.BookSorter;
import com.epam.task.sixth.model.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookSorterImpl implements BookSorter {
    private final Comparator<Book> comparator;

    public BookSorterImpl(Comparator<Book> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List<Book> sort(List<Book> books) {
        List<Book> result = new LinkedList<>(books);
        Collections.sort(result, comparator);
        return result;
    }
}
