package com.epam.tasks.sixth.data.book.specifications;

import com.epam.tasks.sixth.model.Book;

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
