package com.epam.task.sixth.data.book.impl.dao;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.data.book.*;
import com.epam.task.sixth.data.book.impl.sorter.BookSorterImpl;
import com.epam.task.sixth.model.BookTag;
import com.epam.task.sixth.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final Logger LOGGER = LogManager.getLogger(BookDaoImpl.class);
    private final List<Book> books;

    public BookDaoImpl() {
        books = new LinkedList<>();
    }

    /* package private for test */
    BookDaoImpl(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) throws DataException {
        if (!books.contains(book)){
            books.add(book);
        } else {
            throw new DataException("The book already exists");
        }
        LOGGER.info(String.format("book %s was added to repository", book));
    }

    public void removeBook(Book book) throws DataException {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            throw new DataException("The book doesn't exist");
        }
        LOGGER.info(String.format("book %s was removed to repository", book));
    }

    public List<Book> findByTag(BookTag tag, String value) {
        LOGGER.info(String.format("creating %s specification", tag));
        BookSpecificationFactory specificationFactory = new BookSpecificationFactory();
        BookSpecification specification = specificationFactory.create(tag, value);
        LOGGER.info("searching books");
        return specification.find(books);
    }

    public List<Book> sortBooksByTag(BookTag tag) {
        LOGGER.info(String.format("creating %s sort", tag));
        BookComparatorFactory comparatorFactory = new BookComparatorFactory();
        Comparator<Book> comparator = comparatorFactory.create(tag);
        BookSorter sorter = new BookSorterImpl(comparator);
        LOGGER.info("sorting");
        return sorter.sort(books);
    }
}
