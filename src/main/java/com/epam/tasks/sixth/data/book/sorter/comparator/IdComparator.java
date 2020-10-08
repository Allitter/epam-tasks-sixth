package com.epam.tasks.sixth.data.book.sorter.comparator;

import com.epam.tasks.sixth.model.Book;

import java.util.Comparator;

public class IdComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
