package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

public class AllBookSpecification implements BookSpecification {
    @Override
    public boolean specified(Book book) {
        return book != null;
    }
}
