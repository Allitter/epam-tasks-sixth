package com.epam.task.sixth.data.book.impl.specification;

import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuthorBookSpecificationTest {
    private static final String FIRST_AUTHOR = "Author1";
    private static final String SECOND_AUTHOR = "Author2";
    private static final Book FIRST_BOOK = new Book(1, FIRST_AUTHOR, "title", BookGenre.STORY);
    private static final Book SECOND_BOOK = new Book(2, SECOND_AUTHOR, "title", BookGenre.STORY);

    @Test
    public void testSpecifiedShouldReturnSpecifiedBooksWhenAuthorMatches() {
        AuthorBookSpecification specification = new AuthorBookSpecification(FIRST_AUTHOR);
        List<Book> books = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

        List<Book> actual = specification.find(books);

        List<Book> expected = Collections.singletonList(FIRST_BOOK);
        Assert.assertEquals(expected, actual);
    }
}