package com.epam.task.sixth.data.book.impl.dao;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.data.book.BookRepository;
import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.model.Book;
import java.util.LinkedList;
import java.util.List;

public class BookRepositoryMock implements BookRepository {
    private final List<Book> books = new LinkedList<>();

    public void addBook(Book book) throws DataException {
        if (!books.contains(book)){
            books.add(book);
        } else {
            throw new DataException("The book already exists");
        }
    }

    public void removeBook(Book book) throws DataException {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            throw new DataException("The book doesn't exist");
        }
    }

    public void updateBook(Book book) throws DataException {
        if (!books.contains(book)) {
            throw new DataException("The book doesn't exist");
        }

        int index = books.indexOf(book);
        books.set(index, book);
    }

    public List<Book> query(BookSpecification specification) {
        List<Book> result = new LinkedList<>();
        for (Book book : books) {
            if (specification.specified(book)) {
                result.add(book);
            }
        }

        return result;
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }
}
