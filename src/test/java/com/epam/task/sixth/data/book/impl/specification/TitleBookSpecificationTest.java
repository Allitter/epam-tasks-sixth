package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class TitleBookSpecificationTest {
    private static final String TITLE_1 = "Title1";
    private static final String TITLE_2 = "Title2";
    private final TitleBookSpecification specification =
            new TitleBookSpecification(TITLE_1);

    @Test
    public void testSpecifiedShouldReturnTrueWhenTitleMatches() {
        Book book = new Book(1, "author", TITLE_1, BookGenre.STORY);

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTitleNotMatches() {
        Book book = new Book(1, "author", TITLE_2, BookGenre.STORY);

        Assert.assertFalse(specification.specified(book));
    }
}