package com.epam.task.sixth.data.book;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.model.Book;
import java.util.List;

public interface BookRepository {

    void addBook(Book book) throws DataException;

    void removeBook(Book book) throws DataException;

    void updateBook(Book book) throws DataException;

    List<Book> query(BookSpecification specification);
}
