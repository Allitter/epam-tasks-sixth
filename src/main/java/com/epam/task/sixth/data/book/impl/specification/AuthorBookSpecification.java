package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorBookSpecification implements BookSpecification {
    private final String specifiedAuthor;

    public AuthorBookSpecification(String author) {
        this.specifiedAuthor = author;
    }

    @Override
    public List<Book> find(List<Book> books) {
        List<Book> result = new ArrayList<>();
        String author;
        for (Book book : books) {
            author = book.getAuthor();
            if (author.equals(specifiedAuthor)) {
                result.add(book);
            }
        }
        return result;
    }
}
