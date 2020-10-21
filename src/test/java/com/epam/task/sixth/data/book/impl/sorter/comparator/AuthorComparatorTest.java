package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class AuthorComparatorTest {
    private static final String AUTHOR_1 = "1";
    private static final String AUTHOR_2 = "2";
    private static final Book FIRST_BOOK = new Book(1, AUTHOR_1, "title", BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(2, AUTHOR_2, "title", BookGenre.STORY);

    @Test
    public void testCompareShouldCompareAuthors() {
        AuthorComparator comparator = new AuthorComparator();

        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);

        int expected = -1;
        Assert.assertEquals(expected, actual);
    }
}