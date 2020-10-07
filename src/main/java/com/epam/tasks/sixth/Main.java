package com.epam.tasks.sixth;

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

import com.epam.tasks.sixth.data.book.BookDao;
import com.epam.tasks.sixth.model.Book;
import com.epam.tasks.sixth.model.BookTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BookDao dao = new BookDao();
            Book toAdd = new Book(7, "Джек Лондон", "Игра", "рассказ");
            LOGGER.info("trying to add book" + toAdd);
            dao.addBook(toAdd);
            LOGGER.info("trying to find books with genre \"рассказ\"");
            List<Book> foundBooks = dao.findByTag(BookTag.GENRE, "рассказ");
            LOGGER.debug("found books\n" + foundBooks);
            LOGGER.info("trying to remove book" + toAdd);
            dao.removeBook(toAdd);
            BookTag tag  = BookTag.AUTHOR;
            LOGGER.info("trying to sort books by " + tag.name());
            List<Book> sortedBooks = dao.sortBooksByTag(tag);
            LOGGER.debug("sorted books:\n" + sortedBooks);
            LOGGER.info("trying to remove book" + toAdd);
            dao.removeBook(toAdd);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
