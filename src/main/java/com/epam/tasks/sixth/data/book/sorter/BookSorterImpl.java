package com.epam.tasks.sixth.data.book.sorter;

import com.epam.tasks.sixth.model.Book;

import java.util.Comparator;
import java.util.List;

public class BookSorterImpl implements BookSorter{
    private final Comparator<Book> comparator;

    public BookSorterImpl(Comparator<Book> comparator) {
        this.comparator = comparator;
    }


    @Override
    public List<Book> sort(List<Book> books) {
        return null;
    }
}
