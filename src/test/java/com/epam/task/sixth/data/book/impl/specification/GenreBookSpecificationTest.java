package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class GenreBookSpecificationTest {
    private static final BookGenre GENRE_1 = BookGenre.STORY;
    private static final BookGenre GENRE_2 = BookGenre.NOVEL;
    private final GenreBookSpecification specification =
            new GenreBookSpecification(GENRE_1.name());

    @Test
    public void testSpecifiedShouldReturnTrueWhenGenreMatches() {
        Book book = new Book(1, "author", "title", GENRE_1);

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenGenreNotMatches() {
        Book book = new Book(1, "author", "title", GENRE_2);

        Assert.assertFalse(specification.specified(book));
    }
}