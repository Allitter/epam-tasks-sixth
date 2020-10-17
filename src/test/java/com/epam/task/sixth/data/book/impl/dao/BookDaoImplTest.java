package com.epam.task.sixth.data.book.impl.dao;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookTag;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImplTest {
    private static final String TEST_GENRE = "TestGenre";
    private static final String TEST_GENRE_2 = "TestGenre2";
    private static final String TEST_AUTHOR = "TestAuthor2";
    private static final String TEST_AUTHOR_2 = "TestAuthor";
    private static final String TEST_BOOK_TITLE = "TestBookTitle";
    private static final String TEST_BOOK_TITLE_2 = "TestBookTitle2";
    private final BookRepositoryMock mockRepository = new BookRepositoryMock();
    private final BookDaoImpl dao = new BookDaoImpl(mockRepository);

    @Test
    public void testAddBookShouldAddBook() throws DataException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);

        dao.addBook(toAdd);

        Assert.assertTrue(mockRepository.contains(toAdd));
    }

    @Test(expected = DataException.class)
    public void testAddBookShouldThrowException() throws DataException {
        Book toAdd = new Book(100001, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);

        dao.addBook(toAdd);
        dao.addBook(toAdd);
    }

    @Test
    public void testRemoveBookShouldRemoveBook() throws DataException {
        Book book = new Book(100002, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        dao.addBook(book);

        dao.removeBook(book);

        Assert.assertFalse(mockRepository.contains(book));
    }

    @Test(expected = DataException.class)
    public void testRemoveBookShouldThrowException() throws DataException {
        Book book = new Book(100003, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);

        dao.removeBook(book);
    }

    @Test
    public void testFindByTagShouldFindBooksByAuthor() throws DataException {
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
    public void testFindByTagShouldFindBooksByTitle() throws DataException {
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
    public void testFindByTagShouldFindBooksByGenre() throws DataException {
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
    public void testFindByTagShouldFindBooksById() throws DataException {
        List<Book> expected = new LinkedList<>();
        Book book1 = new Book(100010, TEST_AUTHOR, TEST_BOOK_TITLE, TEST_GENRE);
        expected.add(book1);
        dao.addBook(book1);

        List<Book> actual = dao.findByTag(BookTag.ID, "100010");

        Assert.assertEquals(expected, actual);
    }
}