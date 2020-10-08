package com.epam.tasks.sixth.data.book.repository;

import com.epam.tasks.sixth.data.book.specification.BookSpecification;
import com.epam.tasks.sixth.data.DataException;
import com.epam.tasks.sixth.model.Book;
import java.util.List;

public interface BookRepository {

    void addBook(Book book) throws DataException;

    void removeBook(Book book) throws DataException;

    void updateBook(Book book) throws DataException;

    List<Book> query(BookSpecification specification);
}
