package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstBookTitle = firstBook.getTitle();
        String secondBookTitle = secondBook.getTitle();
        return firstBookTitle.compareTo(secondBookTitle);
    }
}
