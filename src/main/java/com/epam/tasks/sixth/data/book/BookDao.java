package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.repos.BookRepository;
import com.epam.tasks.sixth.data.book.repos.MockBookRepo;
import com.epam.tasks.sixth.data.book.sorts.BookSorter;
import com.epam.tasks.sixth.data.book.specifications.AllBookSpecification;
import com.epam.tasks.sixth.data.book.specifications.BookSpecification;
import com.epam.tasks.sixth.data.exceptions.BookAlreadyExistsException;
import com.epam.tasks.sixth.data.exceptions.BookDeletionException;
import com.epam.tasks.sixth.data.exceptions.UnknownBookSorterException;
import com.epam.tasks.sixth.data.exceptions.UnknownBookSpecificationException;
import com.epam.tasks.sixth.model.Book;
import com.epam.tasks.sixth.model.BookTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookDao {
    private static final Logger LOGGER = LogManager.getLogger(BookDao.class);
    private final BookRepository bookRepository = new MockBookRepo();
    private final BookSorterFactory sorterFactory = new BookSorterFactory();
    private final BookSpecificationFactory specificationFactory
            = new BookSpecificationFactory();


    public void addBook(Book book) throws BookAlreadyExistsException {
        bookRepository.addBook(book);
        LOGGER.info(String.format("book %s was added to repository", book));
    }

    public void removeBook(Book book) throws BookDeletionException {
        bookRepository.removeBook(book);
        LOGGER.info(String.format("book %s was removed to repository", book));
    }

    public List<Book> findByTag(BookTag tag, String value)
            throws UnknownBookSpecificationException {

        LOGGER.info(String.format("creating %s specification", tag));
        BookSpecification specification = specificationFactory.create(tag, value);
        LOGGER.info("searching books");
        List<Book> result = bookRepository.query(specification);
        return result;
    }

    public List<Book> getAllBooks() {
        BookSpecification specification = new AllBookSpecification();
        LOGGER.info("getting all books from repository");
        List<Book> result = bookRepository.query(specification);
        return result;
    }

    public List<Book> sortBooksByTag(BookTag tag)
            throws UnknownBookSorterException {

        LOGGER.info(String.format("creating %s sort", tag));
        BookSorter sorter = sorterFactory.create(tag);
        LOGGER.info("sorting");
        List<Book> result = sorter.sort(getAllBooks());
        return result;
    }
}
