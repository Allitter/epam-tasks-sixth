package com.epam.task.sixth.data.book.impl.sorter;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookSorterImplTest {
    private final Comparator<Book> comparator = new ComparatorMock();
    private final BookSorterImpl sorter = new BookSorterImpl(comparator);

    @Test
    public void testSortShouldReturnListSortedByIdWhenNotEmpty() {
        List<Book> books = new LinkedList<>();
        Book book1 = new Book(1, "author1", "title", BookGenre.STORY);
        Book book2 = new Book(2, "author2", "title", BookGenre.STORY);
        List<Book> expected = new LinkedList<>();
        expected.add(book1);
        expected.add(book2);
        books.add(book2);
        books.add(book1);

        List<Book> result = sorter.sort(books);

        Assert.assertEquals(expected, result);
    }
}