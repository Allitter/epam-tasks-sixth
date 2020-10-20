package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class TitleComparatorTest {
    private static final String TITLE_1 = "Title1";
    private static final String TITLE_2 = "Title2";
    private static final Book FIRST_BOOK = new Book(1, "author", TITLE_1, BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(2, "author", TITLE_2, BookGenre.STORY);

    @Test
    public void testCompareShouldCompareTitles() {
        TitleComparator comparator = new TitleComparator();

        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);

        int expected = -1;
        Assert.assertEquals(expected, actual);
    }
}