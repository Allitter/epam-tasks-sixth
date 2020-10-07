package com.epam.tasks.sixth.data.book.repos;

import com.epam.tasks.sixth.data.book.specifications.BookSpecification;
import com.epam.tasks.sixth.data.exceptions.BookAlreadyExistsException;
import com.epam.tasks.sixth.data.exceptions.BookDeletionException;
import com.epam.tasks.sixth.data.exceptions.BookUpdateException;
import com.epam.tasks.sixth.model.Book;
import java.util.List;

public interface BookRepository {

    void addBook(Book book) throws BookAlreadyExistsException;

    void removeBook(Book book) throws BookDeletionException;

    void updateBook(Book book) throws BookUpdateException;

    List<Book> query(BookSpecification specification);
}
