package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class AuthorComparatorTest {
    private static final String AUTHOR_1 = "Author1";
    private static final String AUTHOR_2 = "Author2";
    private final AuthorComparator comparator = new AuthorComparator();

    @Test
    public void testCompareShouldCompareAuthors() {
        Book book1 = new Book(1, AUTHOR_1, "title", "genre");
        Book book2 = new Book(2, AUTHOR_2, "title", "genre");
        int expected = AUTHOR_1.compareTo(AUTHOR_2);

        int actual = comparator.compare(book1, book2);

        Assert.assertEquals(expected, actual);
    }
}