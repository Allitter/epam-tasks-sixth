package com.epam.tasks.sixth.data.book.sorter.comparator;

import com.epam.tasks.sixth.model.Book;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        String author1 = o1.getAuthor();
        String author2 = o2.getAuthor();
        return author1.compareTo(author2);
    }
}
