package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstBookAuthor = firstBook.getAuthor();
        String secondBookAuthor = secondBook.getAuthor();
        return firstBookAuthor.compareTo(secondBookAuthor);
    }
}
