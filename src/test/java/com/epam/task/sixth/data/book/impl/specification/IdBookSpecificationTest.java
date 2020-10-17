package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

public class IdBookSpecificationTest {
    private static final int ID_1 = 1;
    private static final int ID_2 = 2;
    private final IdBookSpecification specification =
            new IdBookSpecification(String.valueOf(ID_1));

    @Test
    public void testSpecifiedShouldReturnTrueWhenIdMatches() {
        Book book = new Book(ID_1, "author", "title", BookGenre.STORY);

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenIdNotMatches() {
        Book book = new Book(ID_2, "author", "title", BookGenre.STORY);

        Assert.assertFalse(specification.specified(book));
    }
}