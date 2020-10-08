package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.repository.BookRepository;
import com.epam.tasks.sixth.data.book.sorter.BookSorter;
import com.epam.tasks.sixth.data.book.specification.AllBookSpecification;
import com.epam.tasks.sixth.data.book.specification.BookSpecification;
import com.epam.tasks.sixth.data.DataException;
import com.epam.tasks.sixth.model.Book;
import com.epam.tasks.sixth.model.BookTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookDao {
    private static final Logger LOGGER = LogManager.getLogger(BookDao.class);
    private final BookRepository bookRepository;
    private final BookSorterFactory sorterFactory = new BookSorterFactory();
    private final BookSpecificationFactory specificationFactory
            = new BookSpecificationFactory();

    public BookDao(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) throws DataException {
        bookRepository.addBook(book);
        LOGGER.info(String.format("book %s was added to repository", book));
    }

    public void removeBook(Book book) throws DataException {
        bookRepository.removeBook(book);
        LOGGER.info(String.format("book %s was removed to repository", book));
    }

    public List<Book> findByTag(BookTag tag, String value)
            throws DataException {

        LOGGER.info(String.format("creating %s specification", tag));
        BookSpecification specification = specificationFactory.create(tag, value);
        LOGGER.info("searching books");
        return bookRepository.query(specification);
    }

    public List<Book> getAllBooks() {
        BookSpecification specification = new AllBookSpecification();
        LOGGER.info("getting all books from repository");
        return bookRepository.query(specification);
    }

    public List<Book> sortBooksByTag(BookTag tag) throws DataException {

        LOGGER.info(String.format("creating %s sort", tag));
        BookSorter sorter = sorterFactory.create(tag);
        LOGGER.info("sorting");
        return sorter.sort(getAllBooks());
    }
}
