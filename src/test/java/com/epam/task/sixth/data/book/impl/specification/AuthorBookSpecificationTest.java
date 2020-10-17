package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class AuthorBookSpecificationTest {
    private static final String AUTHOR_1 = "Author1";
    private static final String AUTHOR_2 = "Author2";
    private final AuthorBookSpecification specification =
            new AuthorBookSpecification(AUTHOR_1);

    @Test
    public void testSpecifiedShouldReturnTrueWhenAuthorMatches() {
        Book book = new Book(1, AUTHOR_1, "title", BookGenre.STORY);

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenAuthorNotMatches() {
        Book book = new Book(1, AUTHOR_2, "title", BookGenre.STORY);

        Assert.assertFalse(specification.specified(book));
    }
}