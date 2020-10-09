package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

public class TitleBookSpecification implements BookSpecification {
    private final String title;

    public TitleBookSpecification(String title) {
        this.title = title;
    }

    public boolean specified(Book book) {
        String toCompare = book.getTitle();
        return toCompare.equals(title);
    }
}
