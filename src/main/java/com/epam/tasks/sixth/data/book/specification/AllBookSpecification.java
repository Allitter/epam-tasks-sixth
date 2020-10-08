package com.epam.tasks.sixth.data.book.specification;

import com.epam.tasks.sixth.model.Book;

public class AllBookSpecification implements BookSpecification {
    @Override
    public boolean specified(Book book) {
        return true;
    }
}
