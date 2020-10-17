package com.epam.task.sixth.data.book.impl.dao;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import com.epam.task.sixth.model.BookTag;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImplTest {
    private static final BookGenre TEST_GENRE = BookGenre.NOVEL;
    private static final BookGenre TEST_GENRE_2 = BookGenre.STORY;
    private static final String TEST_AUTHOR = "TestAuthor2";
    private static final String TEST_AUTHOR_2 = "TestAuthor";
    private static final String TEST_BOOK_TITLE = "TestBookTitle";
    private static final String TEST_BOOK_TITLE_2 = "TestBookTitle2";
    private final BookRepositoryMock stubRepository = new BookRepositoryMock();

    @Test
    public void testAddBookShouldAddBookWhenNotContainsAddingBook() throws DataException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);

        dao.addBook(toAdd);

        Assert.assertTrue(stubRepository.contains(toAdd));
    }

    @Test(expected = DataException.class)
    public void testAddBookShouldThrowExceptionWhenAlreadyContainsBook() throws DataException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);

        dao.addBook(toAdd);
        dao.addBook(toAdd);
    }

    @Test
    public void testRemoveBookShouldRemoveBookWhenContainsBook() throws DataException {
        Book book = new Book(100002, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);
        dao.addBook(book);

        dao.removeBook(book);

        Assert.assertFalse(stubRepository.contains(book));
    }

    @Test(expected = DataException.class)
    public void testRemoveBookShouldThrowExceptionWhenNotContainsBook() throws DataException {
        Book book = new Book(100003, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);

        dao.removeBook(book);
    }

    @Test
    public void testFindByTagShouldFindBooksByAuthorWhenContainsSuchBooks() throws DataException {
        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100004, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100005, TEST_AUTHOR, TEST_BOOK_TITLE_2, TEST_GENRE_2);
        expected.add(book1);
        expected.add(book2);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.AUTHOR, TEST_AUTHOR);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksByTitleWhenContainsSuchBooks() throws DataException {
        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100006, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100007, TEST_AUTHOR_2, TEST_BOOK_TITLE, TEST_GENRE_2);
        expected.add(book1);
        expected.add(book2);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.TITLE, TEST_BOOK_TITLE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksByGenreWhenContainsSuchBooks() throws DataException {
        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100008, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        Book book2 = new Book(100009, TEST_AUTHOR_2, TEST_BOOK_TITLE_2, TEST_GENRE);
        expected.add(book1);
        expected.add(book2);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);
        dao.addBook(book1);
        dao.addBook(book2);

        List<Book> actual = dao.findByTag(BookTag.GENRE, TEST_GENRE.name());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindByTagShouldFindBooksByIdWhenContainsSuchBooks() throws DataException {
        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100010, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        expected.add(book1);
        BookDaoImpl dao = new BookDaoImpl(stubRepository);
        dao.addBook(book1);

        List<Book> actual = dao.findByTag(BookTag.ID, "100010");

        Assert.assertEquals(expected, actual);
    }
}