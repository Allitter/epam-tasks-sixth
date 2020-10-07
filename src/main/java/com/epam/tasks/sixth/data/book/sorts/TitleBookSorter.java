package com.epam.tasks.sixth.data.book.sorts;

import com.epam.tasks.sixth.model.Book;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TitleBookSorter implements BookSorter {
    @Override
    public List<Book> sort(List<Book> books) {
        List<Book> result = new LinkedList<>(books);
        result.sort(Comparator.comparing(Book::getTitle));
        return result;
    }
}
