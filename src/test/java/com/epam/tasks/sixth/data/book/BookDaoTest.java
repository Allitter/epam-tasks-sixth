package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.repos.MockBookRepo;
import com.epam.tasks.sixth.data.exceptions.BookAlreadyExistsException;
import com.epam.tasks.sixth.data.exceptions.BookDeletionException;
import com.epam.tasks.sixth.data.exceptions.UnknownBookSpecificationException;
import com.epam.tasks.sixth.model.Book;
import com.epam.tasks.sixth.model.BookTag;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BookDaoTest {
    private static final String TEST_GENRE = "TestGenre";
    private static final String TEST_GENRE_2 = "TestGenre2";
    private static final String TEST_AUTHOR = "TestAuthor2";
    private static final String TEST_AUTHOR_2 = "TestAuthor";
    private static final String TEST_BOOK_TITLE = "TestBookTitle";
    private static final String TEST_BOOK_TITLE_2 = "TestBookTitle2";
    private final BookDao dao = new BookDao(new MockBookRepo());

    @Test
    public void testAddBookShouldAddBook() throws BookAlreadyExistsException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        List<Book> expected = dao.getAllBooks();
        expected.add(toAdd);

        dao.addBook(toAdd);
        List<Book> actual = dao.getAllBooks();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = BookAlreadyExistsException.class)
    public void testAddBookShouldThrowException() throws BookAlreadyExistsException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);

        dao.addBook(toAdd);
        dao.addBook(toAdd);
    }

    @Test
    public void testRemoveBookShouldRemoveBook() throws BookDeletionException, BookAlreadyExistsException {
        Book book = new Book(100002, "Джек Лондон", "Игра", "рассказ");
        List<Book> expected = dao.getAllBooks();
        dao.addBook(book);

        dao.removeBook(book);
        List<Book> actual = dao.getAllBooks();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = BookDeletionException.class)
    public void testRemoveBookShouldThrowException() throws BookDeletionException {
        Book book = new Book(100003, "Джек Лондон", "Игра", "рассказ");

        dao.removeBook(book);
    }

    @Test
    public void testFindByTagShouldFindBooksByAuthor()
            throws BookAlreadyExistsException, UnknownBookSpecificationException {

        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100004, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100005, TEST_AUTHOR, TEST_BOOK_TITLE_2, TEST_GENRE_2);
        expected.add(book1);
        expected.add(book2);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.AUTHOR, TEST_AUTHOR);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksByTitle()
            throws BookAlreadyExistsException, UnknownBookSpecificationException {

        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100006, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100007, TEST_AUTHOR_2, TEST_BOOK_TITLE, TEST_GENRE_2);
        expected.add(book1);
        expected.add(book2);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.TITLE, TEST_BOOK_TITLE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksByGenre()
            throws BookAlreadyExistsException, UnknownBookSpecificationException {

        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100008, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100009, TEST_AUTHOR_2, TEST_BOOK_TITLE_2, TEST_GENRE);
        expected.add(book1);
        expected.add(book2);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.GENRE, TEST_GENRE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksById()
            throws BookAlreadyExistsException, UnknownBookSpecificationException {

        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100010, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        expected.add(book1);
        dao.addBook(book1);

        List<Book> actual = dao.findByTag(BookTag.ID, "100010");

        Assert.assertEquals(expected, actual);
    }
}