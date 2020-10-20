package com.epam.task.sixth.data.book.impl.dao;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImplTest {
    private static final BookGenre FIRST_GENRE = BookGenre.NOVEL;
    private static final String FIRST_AUTHOR = "Mark Twain";
    private static final String FIRST_TITLE = "Adventures of Huckleberry Finn";
    public static final int FIRST_ID = 100001;
    private static final Book FIRST_BOOK = new Book(FIRST_ID, FIRST_AUTHOR, FIRST_TITLE, FIRST_GENRE);

    @Test
    public void testAddBookShouldAddBookWhenNotContainsAddingBook() throws DataException {
        List<Book> list = new ArrayList<>();
        BookDaoImpl dao = new BookDaoImpl(list);

        dao.addBook(FIRST_BOOK);

        Assert.assertTrue(list.contains(FIRST_BOOK));
    }

    @Test(expected = DataException.class)
    public void testAddBookShouldThrowExceptionWhenAlreadyContainsBook() throws DataException {
        // Used ArrayList because Arrays.asList produces unmodifiable List
        List<Book> list = new ArrayList<>();
        list.add(FIRST_BOOK);
        BookDaoImpl dao = new BookDaoImpl(list);

        dao.addBook(FIRST_BOOK);
    }

    @Test
    public void testRemoveBookShouldRemoveBookWhenContainsBook() throws DataException {
        List<Book> list = new ArrayList<>();
        list.add(FIRST_BOOK);
        BookDaoImpl dao = new BookDaoImpl(list);

        dao.removeBook(FIRST_BOOK);

        Assert.assertTrue(list.contains(FIRST_BOOK));
    }

    @Test(expected = DataException.class)
    public void testRemoveBookShouldThrowExceptionWhenNotContainsBook() throws DataException {
        List<Book> list = new ArrayList<>();
        BookDaoImpl dao = new BookDaoImpl(list);

        dao.removeBook(FIRST_BOOK);
    }
}