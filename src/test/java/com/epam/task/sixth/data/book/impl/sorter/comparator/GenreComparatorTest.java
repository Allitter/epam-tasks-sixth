package com.epam.task.sixth.data.book.impl.sorter.comparator;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class GenreComparatorTest {
    private static final BookGenre GENRE_1 = BookGenre.STORY;
    private static final BookGenre GENRE_2 = BookGenre.NOVEL;
    private static final Book FIRST_BOOK = new Book(1, "author", "title", GENRE_1);
    private static final Book SECOND_BOOK = new Book(2, "author", "title", GENRE_2);

    @Test
    public void testCompareShouldCompareGenres() {
        GenreComparator comparator = new GenreComparator();

        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);

        int expected = -1;
        Assert.assertEquals(expected, actual);
    }
}