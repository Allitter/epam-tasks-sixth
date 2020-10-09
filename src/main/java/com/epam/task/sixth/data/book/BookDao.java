package com.epam.task.sixth.data.book;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookTag;

import java.util.List;

public interface BookDao {
    void addBook(Book book) throws DataException;

    void removeBook(Book book) throws DataException;

    List<Book> findByTag(BookTag tag, String value) throws DataException;

    List<Book> sortBooksByTag(BookTag tag) throws DataException;

    List<Book> getAllBooks();
}
