package com.epam.tasks.sixth.data.book.sorters;

import com.epam.tasks.sixth.model.Book;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AuthorBookSorter implements BookSorter {
    @Override
    public List<Book> sort(List<Book> books) {
        List<Book> result = new LinkedList<>(books);
        result.sort(Comparator.comparing(Book::getAuthor));
        return result;
    }
}
