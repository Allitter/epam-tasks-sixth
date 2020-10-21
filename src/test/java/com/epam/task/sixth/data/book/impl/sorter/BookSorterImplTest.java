package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BookSorterImplTest {
    private static final Book FIRST_BOOK = new Book(1, "author1", "title", BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(2, "author2", "title", BookGenre.STORY);

    @Test
    public void testSortShouldReturnListSortedByIdWhenNotEmpty() {
        Comparator<Book> comparator = new ComparatorMock();
        BookSorterImpl sorter = new BookSorterImpl(comparator);
        List<Book> books = Arrays.asList(SECOND_BOOK, FIRST_BOOK);

        List<Book> result = sorter.sort(books);

        List<Book> expected = Arrays.asList(FIRST_BOOK, SECOND_BOOK);
        Assert.assertEquals(expected, result);
    }
}