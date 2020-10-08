package com.epam.tasks.sixth.data.book.sorter.comparator;

import com.epam.tasks.sixth.model.Book;

import java.util.Comparator;

public class GenreComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        String genre1 = o1.getGenre();
        String genre2 = o2.getGenre();
        return genre1.compareTo(genre2);
    }
}
