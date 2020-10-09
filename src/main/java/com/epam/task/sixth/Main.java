package com.epam.task.sixth;

// TODO Разработать класс Book с 4-5 полями. Для выполнения основных операций со
//  списком книг, которые хранятся в некотором хранилище разработать класс
//  BookDao с функциональностью:
//   -addBook (добавить книгу в хранилище в случае, если такой книги нет, в
//      противном случае выбросить исключение);
//   -removeBook (удалить книгу, если она есть, в противном случае выбросить
//      исключение);
//   -findByTag(найти книгу по заданному критерию); (enum name, String value)
//      Specification - List<Book> find(value)  (e.g. TitleSpecification )
//   -sortBooksByTag (отсортировать список книг по заданному критерию).

import com.epam.task.sixth.data.book.impl.dao.BookDaoImpl;
import com.epam.task.sixth.data.book.impl.repository.MockBookRepository;
import com.epam.task.sixth.model.BookTag;
import com.epam.task.sixth.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BookDaoImpl dao = new BookDaoImpl(new MockBookRepository());
            Book book = new Book(7, "Джек Лондон", "Игра", "рассказ");

            LOGGER.info("trying to add book" + book);
            dao.addBook(book);

            LOGGER.info("trying to find books with genre \"рассказ\"");
            List<Book> foundBooks = dao.findByTag(BookTag.GENRE, "рассказ");
            LOGGER.debug("found books\n" + foundBooks);

            LOGGER.info("trying to remove book" + book);
            dao.removeBook(book);

            BookTag tag  = BookTag.AUTHOR;
            LOGGER.info("trying to sort books by " + tag.name());
            List<Book> sortedBooks = dao.sortBooksByTag(tag);
            LOGGER.debug("sorted books:\n" + sortedBooks);

            LOGGER.info("trying to remove book" + book);
            dao.removeBook(book);                 // removing not existing book
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
