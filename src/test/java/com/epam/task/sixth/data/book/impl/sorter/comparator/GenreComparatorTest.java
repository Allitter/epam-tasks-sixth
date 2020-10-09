package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class GenreComparatorTest {
    private static final String GENRE_1 = "Genre1";
    private static final String GENRE_2 = "Genre2";
    private final GenreComparator comparator = new GenreComparator();

    @Test
    public void testCompareShouldCompareGenres() {
        Book book1 = new Book(1, "author", "title", GENRE_1);
        Book book2 = new Book(2, "author", "title", GENRE_2);
        int expected = GENRE_1.compareTo(GENRE_2);

        int actual = comparator.compare(book1, book2);

        Assert.assertEquals(expected, actual);
    }
}