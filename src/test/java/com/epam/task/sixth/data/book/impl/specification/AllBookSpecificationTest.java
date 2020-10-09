package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class AllBookSpecificationTest {
    private final AllBookSpecification specification =
            new AllBookSpecification();

    @Test
    public void testSpecifiedShouldReturnTrueForAnyBook() {
        Book book = new Book(1, "text", "text", "text");

        Assert.assertTrue(specification.specified(book));
    }

    @Test
    public void testSpecifiedShouldReturnFalseForNull() {
        Assert.assertFalse(specification.specified(null));
    }
}