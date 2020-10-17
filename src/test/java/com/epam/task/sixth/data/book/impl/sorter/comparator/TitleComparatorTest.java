package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class TitleComparatorTest {
    private static final String TITLE_1 = "Title1";
    private static final String TITLE_2 = "Title2";
    private final TitleComparator comparator = new TitleComparator();

    @Test
    public void testCompareShouldCompareTitles() {
        Book book1 = new Book(1, "author", TITLE_1, BookGenre.STORY);
        Book book2 = new Book(2, "author", TITLE_2, BookGenre.STORY);
        int expected = TITLE_1.compareTo(TITLE_2);

        int actual = comparator.compare(book1, book2);

        Assert.assertEquals(expected, actual);
    }
}