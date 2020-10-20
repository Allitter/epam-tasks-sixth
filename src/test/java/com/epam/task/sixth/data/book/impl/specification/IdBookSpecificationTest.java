package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IdBookSpecificationTest {
    private static final int ID_1 = 1;
    private static final int ID_2 = 2;
    private static final Book FIRST_BOOK = new Book(ID_1, "author", "title", BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(ID_2, "author", "title", BookGenre.STORY);

    @Test
    public void testSpecifiedShouldReturnTrueWhenIdMatches() {
        IdBookSpecification specification = new IdBookSpecification(String.valueOf(ID_1));
        List<Book> books = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

        List<Book> actual = specification.find(books);

        List<Book> expected = Collections.singletonList(FIRST_BOOK);
        Assert.assertEquals(expected, actual);
    }
}