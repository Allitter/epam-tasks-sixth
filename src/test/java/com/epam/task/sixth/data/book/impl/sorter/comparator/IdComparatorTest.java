package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class IdComparatorTest {
    private static final int ID_1 = 1;
    private static final int ID_2 = 2;
    private final IdComparator comparator = new IdComparator();

    @Test
    public void testCompareShouldCompareId() {
        Book book1 = new Book(ID_1, "author", "title", BookGenre.STORY);
        Book book2 = new Book(ID_2, "author", "title", BookGenre.STORY);
        int expected = Integer.compare(ID_1, ID_2);

        int actual = comparator.compare(book1, book2);

        Assert.assertEquals(expected, actual);
    }
}