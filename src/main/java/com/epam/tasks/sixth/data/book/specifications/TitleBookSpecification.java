package com.epam.tasks.sixth.data.book.specifications;

import com.epam.tasks.sixth.model.Book;

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
