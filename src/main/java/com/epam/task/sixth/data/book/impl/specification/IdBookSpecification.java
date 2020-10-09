package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

public class IdBookSpecification implements BookSpecification {
    private final int id;

    public IdBookSpecification(String id) {
        this.id = Integer.parseInt(id);
    }

    public boolean specified(Book book) {
        int toCompare = book.getId();
        return id == toCompare;
    }
}
