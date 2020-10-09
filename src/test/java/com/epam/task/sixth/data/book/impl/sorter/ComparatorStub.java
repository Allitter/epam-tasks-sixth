package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.model.Book;

import java.util.Comparator;

public class ComparatorStub implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        return Integer.compare(id1, id2);
    }
}
