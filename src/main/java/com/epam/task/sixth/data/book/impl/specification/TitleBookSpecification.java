package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;

import java.util.ArrayList;
import java.util.List;

public class TitleBookSpecification implements BookSpecification {
    private final String specifiedTitle;

    public TitleBookSpecification(String title) {
        this.specifiedTitle = title;
    }

    public boolean specified(Book book) {
        String title = book.getTitle();
        return title.equals(specifiedTitle);
    }

    @Override
    public List<Book> find(List<Book> books) {
        List<Book> result = new ArrayList<>();
        String title;
        for (Book book : books) {
            title = book.getTitle();
            if (title.equals(specifiedTitle)) {
                result.add(book);
            }
        }
        return result;
    }
}
