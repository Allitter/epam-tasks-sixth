package com.epam.task.sixth;

import com.epam.task.sixth.data.book.BookDao;
import com.epam.task.sixth.data.book.impl.dao.BookDaoImpl;
import com.epam.task.sixth.model.BookGenre;
import com.epam.task.sixth.model.BookTag;
import com.epam.task.sixth.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BookDao dao = new BookDaoImpl();
            Book book = new Book(7, "Джек Лондон", "Игра", BookGenre.STORY);

            LOGGER.info("trying to add book" + book);
            dao.addBook(book);

            LOGGER.info("trying to find books with genre \"story\"");
            List<Book> foundBooks = dao.findByTag(BookTag.GENRE, "story");
            LOGGER.debug("found books\n" + foundBooks);

            LOGGER.info("trying to remove book" + book);
            dao.removeBook(book);

            BookTag tag  = BookTag.AUTHOR;
            LOGGER.info("trying to sort books by " + tag.name());
            List<Book> sortedBooks = dao.sortBooksByTag(tag);
            LOGGER.debug("sorted books:\n" + sortedBooks);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
