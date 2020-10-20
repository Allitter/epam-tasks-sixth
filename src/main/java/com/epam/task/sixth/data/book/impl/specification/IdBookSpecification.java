package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;

import java.util.ArrayList;
import java.util.List;

public class IdBookSpecification implements BookSpecification {
    private final int specifiedId;

    public IdBookSpecification(String id) {
        this.specifiedId = Integer.parseInt(id);
    }

    public boolean specified(Book book) {
        int id = book.getId();
        return specifiedId == id;
    }

    @Override
    public List<Book> find(List<Book> books) {
        List<Book> result = new ArrayList<>();
        int id;
        for (Book book : books) {
            id = book.getId();
            if (id == specifiedId) {
                result.add(book);
            }
        }
        return result;
    }
}
