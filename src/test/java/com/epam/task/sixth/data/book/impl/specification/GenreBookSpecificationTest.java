package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenreBookSpecificationTest {
    private static final BookGenre FIRST_GENRE = BookGenre.STORY;
    private static final BookGenre SECOND_GENRE = BookGenre.NOVEL;
    private static final Book FIRST_BOOK = new Book(1, "author", "title", FIRST_GENRE);
    private static final Book SECOND_BOOK = new Book(2, "author", "title", SECOND_GENRE);

    @Test
    public void testSpecifiedShouldReturnSpecifiedBooksWhenGenreMatches() {
        String firstGenreName = FIRST_GENRE.name();
        GenreBookSpecification specification = new GenreBookSpecification(firstGenreName);
        List<Book> books = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

        List<Book> actual = specification.find(books);

        List<Book> expected = Collections.singletonList(FIRST_BOOK);
        Assert.assertEquals(expected, actual);
    }
}