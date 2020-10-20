package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TitleBookSpecificationTest {
    private static final String TITLE_1 = "Title1";
    private static final String TITLE_2 = "Title2";
    private static final Book FIRST_BOOK = new Book(1, "author", TITLE_1, BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(2, "author", TITLE_2, BookGenre.STORY);

    @Test
    public void testSpecifiedShouldReturnTrueWhenTitleMatches() {
        TitleBookSpecification specification = new TitleBookSpecification(TITLE_1);
        List<Book> books = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

        List<Book> actual = specification.find(books);

        List<Book> expected = Collections.singletonList(FIRST_BOOK);
        Assert.assertEquals(expected, actual);
    }
}
