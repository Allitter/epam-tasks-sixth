package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class IdComparatorTest {
    private static final int ID_1 = 1;
    private static final int ID_2 = 2;
    private static final Book FIRST_BOOK = new Book(ID_1, "author", "title", BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(ID_2, "author", "title", BookGenre.STORY);

    @Test
    public void testCompareShouldCompareId() {
        IdComparator comparator = new IdComparator();

        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);

        int expected = -1;
        Assert.assertEquals(expected, actual);
    }
}