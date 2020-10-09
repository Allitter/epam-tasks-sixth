package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class GenreBookSpecificationTest {
    private static final String GENRE_1 = "Genre1";
    private static final String GENRE_2 = "Genre2";
    private final GenreBookSpecification specification =
            new GenreBookSpecification(GENRE_1);

    @Test
    public void testSpecifiedShouldReturnTrueForProperGenre() {
        Book book = new Book(1, "author", "title", GENRE_1);

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenGenreNotMatches() {
        Book book = new Book(1, "author", "title", GENRE_2);

        Assert.assertFalse(specification.specified(book));
    }
}